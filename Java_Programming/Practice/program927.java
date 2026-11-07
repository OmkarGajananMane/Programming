import java.io.*;
import java.net.*;

class program927
{
    public static int ClientCount = 1;

    public static void main(String A[])
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);

            System.out.println("-------------------------------------");
            System.out.println("----- Marvellous Server Started -----");
            System.out.println("-------------------------------------");

            // Loop for multiple client requests
            while(true)
            {
                System.out.println("Server is waiting for client request");

                Socket clientsocket = serversocket.accept();
                
                System.out.println("Client connected sucesfully");

                // Thread gets created for client
                Thread t = new Thread(() -> HandleClientRequest(clientsocket));

                t.start();
            } // End of while
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    } // End of main

    // Request handler for each client requests
    public static void HandleClientRequest(Socket socket)
    {
        System.out.println("New thread gets created for client no : "+ClientCount);
        ClientCount++;

        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to Marvellous Server");
        
            while(true)
            {
                // Read command from client
                String command = dis.readUTF();

                System.out.println("Command received from client : "+command);

                String parts[] = command.split(" ");

                String operation = parts[0].toUpperCase();

                if(operation.equals("QUIT"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : QUIT");
                        
                        continue;
                    }

                    dos.writeUTF("Disconneced from server");
                
                    ClientCount--;
                    
                    break;
                }

                if(operation.equals("GET"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : GET <FileName>");
                        
                        continue;
                    }
                }
                else if(operation.equals("PUT"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : PUT <FileName>");
                        
                        continue;
                    }
                }
                else if(operation.equals("INFO"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : INFO <FileName>");
                        
                        continue;
                    }
                }
                else if(operation.equals("SIZE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : SIZE <FileName>");
                        
                        continue;
                    }
                }
                else if(operation.equals("EXISTS"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : EXISTS <FileName>");
                        
                        continue;
                    }
                }
                else if(operation.equals("RENAME"))
                {
                    if(parts.length != 3)
                    {
                        dos.writeUTF("Usage : RENAME <OldFileName> <NewFileName>");
                        
                        continue;
                    }
                }
                else if(operation.equals("DELETE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : DELETE <FileName>");
                        
                        continue;
                    }

                }
                else if(operation.equals("LIST"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : LIST");
                        
                        continue;
                    }

                }                                              
                else
                {
                    dos.writeUTF("Invalid operation");
                }

            }// End of while

            socket.close();
            dis.close();
            dos.close();

            System.out.println("Client disconnected");

        } // End of try

        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }

    } // End of HandleClientRequest() method

} // End of class