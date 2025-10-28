import java.io.*;
import java.net.*;

public class server {
    public static void main(String args[]) throws IOException 
    {
        // create a server socket on port number 9090
        ServerSocket server_socket = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client connection...");

        // Accept incoming client connection
        Socket client = server_socket.accept();
        System.out.println("Client connected!");

        // Setup input and output streams for communication with the client
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // Read message from client
        String message = in.readLine();
        System.out.println("Client says: " + message);

        // Send response to the client
        out.println("Message received by the server.");

        // Close the client socket
        client.close();
        // Close the server socket
        server_socket.close();
    }
}