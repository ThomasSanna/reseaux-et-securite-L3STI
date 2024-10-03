import selectors
import socket
from utils import *

# Create a default selector
sel = selectors.DefaultSelector()

def accept(sock, mask):
    conn, addr = sock.accept()  # Should be ready
    print('Accepted connection from', addr)
    conn.setblocking(False)
    sel.register(conn, selectors.EVENT_READ, read)

def read(conn, mask):
    data = conn.recv(1000)  # Should be ready
    if data:
        data = decode_message(data)
        print('Echoing', repr(data), 'to', conn)
        conn.send(encode_message(data))
    else:
        print('Closing connection to', conn)
        sel.unregister(conn)
        conn.close()

# Create and bind the socket
sock = socket.socket()
sock.bind(('localhost', 12345))  # Change port to 12345 to match the client
sock.listen(100)
sock.setblocking(False)
sel.register(sock, selectors.EVENT_READ, accept)

print('Server started on port 12345')

# Event loop
while True:
    events = sel.select()
    for key, mask in events:
        callback = key.data
        callback(key.fileobj, mask)