import java.io.*;
import java.net.*;

class program921
{
    public static void main(String A[])
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);

            System.out.println("-------------------------------------");
            System.out.println("----- Marvellous Server Started -----");
            System.out.println("-------------------------------------");

            System.out.println("Server is waiting for client request");

            Socket clientsocket = serversocket.accept();
            
            System.out.println("Client connected sucesfully");

            // Thread gets created for client
            Thread t = new Thread(() -> HandleClientRequest(clientsocket));

            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    } // End of main

    public static void HandleClientRequest(Socket socket)
    {
        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to Marvellous Server");
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    }

} // End of class