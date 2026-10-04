# Java Client-Server File Transfer System

A **multi-client Client-Server File Transfer System developed in Java using TCP Socket Programming and Multithreading**.

The project demonstrates how a Java client communicates with a server over a TCP connection and performs different file-management operations through a command-based communication protocol.

## Project Overview

The system consists of two main components:

- **Server (`program934.java`)** – Creates a TCP server on port `9000`, accepts client connections, creates a separate thread for each client, and processes client commands.
- **Client (`program935.java`)** – Connects to the server through a TCP socket and allows the user to perform file operations using commands.

The server uses Java's `ServerSocket` and `Socket` classes for network communication and uses multithreading to handle multiple clients concurrently.

## Architecture

```text
                         JAVA FILE TRANSFER SYSTEM
                         =========================

                         SERVER
                    ServerSocket : 9000
                            |
                            |
                    accept() client
                            |
              +-------------+-------------+
              |             |             |
              v             v             v
         Client Thread  Client Thread  Client Thread
              |             |             |
              v             v             v
          Client 1       Client 2       Client 3
              |             |             |
              +-------------+-------------+
                            |
                     TCP Communication
                            |
                    File Operations
                            |
       +---------+----------+----------+---------+
       |         |          |          |         |
      GET       PUT       LIST       DELETE    RENAME
```

## Features

### 1. File Download

The `GET` command allows a client to download a file from the server.

```text
GET Demo.txt
```

The server sends:

1. File availability status
2. File size
3. File data

The client receives the data and stores it locally as:

```text
Download_Demo.txt
```

### 2. File Upload

The `PUT` command allows the client to upload a local file to the server.

```text
PUT Demo.txt
```

The client sends:

1. File name
2. File size
3. File data

The server receives the data and creates the file.

### 3. File Listing

```text
LIST
```

Displays all regular files available in the server directory.

### 4. File Information

```text
INFO Demo.txt
```

Displays information such as:

- File name
- File size
- Read permission
- Write permission

### 5. File Size

```text
SIZE Demo.txt
```

Displays the size of the requested file in bytes.

### 6. File Existence

```text
EXISTS Demo.txt
```

Checks whether the requested file exists on the server.

### 7. Rename File

```text
RENAME Demo.txt DemoX.txt
```

Renames an existing server-side file.

### 8. Delete File

```text
DELETE Demo.txt
```

Deletes a file from the server.

### 9. Multiple Client Support

The server continuously waits for new client connections.

For every connected client, it creates a separate thread:

```java
Thread t = new Thread(() ->
    HandleClientRequest(clientsocket)
);

t.start();
```

This allows multiple clients to communicate with the server concurrently.

## Communication Flow

The client and server communicate using Java's:

```text
Socket
   |
   +-- DataInputStream
   |
   +-- DataOutputStream
```

Example:

```text
Client
   |
   |  "GET Demo.txt"
   |
   v
Server
   |
   | Check file
   |
   | File Size
   |
   | File Data
   v
Client
   |
   | Save received data
   v
Download_Demo.txt
```

## Technologies Used

- Java
- Java Networking
- TCP/IP
- Socket Programming
- ServerSocket
- Multithreading
- File Handling
- DataInputStream
- DataOutputStream
- FileInputStream
- FileOutputStream

## Key Concepts Demonstrated

This project demonstrates practical implementation of:

- Client-Server Architecture
- TCP Socket Communication
- Network Programming
- Multithreading
- Stream-Based Communication
- File Upload and Download
- Binary File Transfer
- Command Parsing
- File System Operations
- Concurrent Client Handling
- Exception Handling

## How to Run

### 1. Start the Server

Compile and run:

```bash
javac program934.java
java program934
```

The server starts listening on:

```text
Port: 9000
```

### 2. Start the Client

In another terminal:

```bash
javac program935.java
java program935
```

The client connects to:

```text
127.0.0.1:9000
```

### 3. Execute Commands

Example:

```text
LIST

EXISTS Demo.txt

INFO Demo.txt

SIZE Demo.txt

GET Demo.txt

PUT Sample.txt

RENAME Demo.txt DemoX.txt

DELETE DemoX.txt

QUIT
```

## Project Structure

```text
Java-File-Transfer-System/
│
├── program934.java       # Server
├── program935.java       # Client
└── README.md             # Project Documentation
```

## Learning Outcome

This project provided practical experience in developing a network-based Java application using **TCP sockets, client-server communication, multithreading, stream handling, and file I/O**.

It demonstrates how multiple clients can connect to a centralized server and perform file-management and file-transfer operations through a custom command-based protocol.