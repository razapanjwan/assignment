import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Replace with your server's IP address if running on different computers
            String serverIP = "127.0.0.1"; // localhost for same machine
            int port = 5000;

            Socket socket = new Socket(serverIP, port);
            System.out.println("Connected to server: " + serverIP);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Hello Server! This is the client.");

            String response = input.readLine();
            System.out.println("Server replied: " + response);

            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
