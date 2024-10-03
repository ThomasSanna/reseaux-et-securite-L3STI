import selectors
import socket
import utils

# Create a default selector
sel = selectors.DefaultSelector()

# List to store accepted sockets
clients = []


def accept(sock, mask):
    conn, addr = sock.accept()  # Should be ready
    print("Accepted connection from", addr)
    conn.setblocking(False)
    sel.register(conn, selectors.EVENT_READ, read)
    clients.append((conn, addr))  # Add the new connection to the clients list


def read(conn, mask):
    data = conn.recv(1000)  # Should be ready
    addr = conn.getpeername()
    if data:
        message = utils.decode_message(data)
         # Get the address of the client
        print(f"Received message from {addr}: {message}")

        # Create the message to be sent to other clients
        encoded_message = utils.encode_message(message)

        # Send the message to all other clients
        for client, client_addr in clients:
            if client != conn:
                client.send(encoded_message)
    else:
        print("Closing connection to", conn)
        sel.unregister(conn)
        conn.close()
        clients.remove(
            (conn, addr)
        )  # Remove the connection from the clients list


# Create and bind the socket
sock = socket.socket()
sock.bind(("localhost", 12345))  # Change port to 12345 to match the client
sock.listen(100)
sock.setblocking(False)
sel.register(sock, selectors.EVENT_READ, accept)

print("Server started on port 12345")

# Event loop
while True:
    events = sel.select()
    for key, mask in events:
        callback = key.data
        callback(key.fileobj, mask)
