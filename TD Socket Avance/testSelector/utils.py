import time
import struct

def encode_message(message: str) -> bytes:
  timestamp = time.strftime('%Y-%m-%d %H:%M:%S', time.gmtime())
  full_message = f"{timestamp} {message}"
  message_bytes = full_message.encode('utf-8')
  header = struct.pack('>I', len(message_bytes)) # >I signifie que le format est big-endian unsigned int
  return header + message_bytes

def decode_message(data: bytes) -> str:
  message_length = struct.unpack('>I', data[:4])[0]
  full_message = data[4:].decode('utf-8')
  yearMonthDay, hourMinSec, message = full_message.split(' ', 2)
  return message