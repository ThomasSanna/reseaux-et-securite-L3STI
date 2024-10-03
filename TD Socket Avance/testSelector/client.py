import threading
import socket
from utils import *


# Define and connect the socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect(('localhost', 12345))

def send_loop():
    while True:
        message = input()
        sock.send(encode_message(message))
        
def receive_loop():
    while True:
        message = sock.recv(1000)
        print("Donnée envoyée par le serveur : ", decode_message(message))



thread_send = threading.Thread(target=send_loop)
thread_send.start()

thread_receive = threading.Thread(target=receive_loop)
thread_receive.start()

thread_send.join()
thread_receive.join()