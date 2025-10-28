import java.io.*;
import java.net.*;

public class MultiThreadv2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server started on port 6789. Waiting for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();  
            tcp_server_mt_test t = new tcp_server_mt_test(clientSocket);
            t.start(); // run client thread
        }
    }
}

class tcp_server_mt_test extends Thread {
    private static int clientCount = 0;
    private static int activeClients = 0;

    private Socket clientSocket;
    private int clientId;

    public tcp_server_mt_test(Socket socket) {
        this.clientSocket = socket;
        clientId = ++clientCount; 
    }

    @Override
    public void run() {
        try {
            handleClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleClient() throws IOException {
        activeClients++;
        System.out.println("Client " + clientId + " connected. Active clients: " + activeClients);

        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

        String clientMsg = "", serverMsg = "";

        while (true) {
            clientMsg = dis.readUTF();
            if (clientMsg.equalsIgnoreCase("stop")) {
                System.out.println("Client " + clientId + " disconnected.");
                dos.writeUTF("stop");
                dos.flush();
                break;
            }

            System.out.println("Client " + clientId + ": " + clientMsg);

            System.out.print("Reply to Client " + clientId + ": ");
            serverMsg = serverInput.readLine();
            dos.writeUTF(serverMsg);
            dos.flush();

            if (serverMsg.equalsIgnoreCase("stop")) {
                System.out.println("You ended conversation with Client " + clientId);
                break;
            }
        }

        dis.close();
        dos.close();
        clientSocket.close();

        activeClients--;
        System.out.println("Client " + clientId + " removed. Active clients: " + activeClients);
    }
}