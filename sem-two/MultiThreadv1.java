import java.io.*;
import java.net.*;

public class MultiThreadv1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server started on port 6789. Waiting for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            single_client_handler t = new single_client_handler(clientSocket);
            t.start(); 

            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Server interrupted while waiting for client to finish.");
            }
        }
    }
}
class single_client_handler extends Thread {
    private static int clientCount = 0;  
    private Socket clientSocket;
    private int clientId;

    public single_client_handler(Socket socket) {
        this.clientSocket = socket;
        clientId = ++clientCount;
    }

    @Override
    public void run() {
        try {
            handleClient();
        } catch (IOException e) {
            System.out.println("Connection error with client " + clientId);
        }
    }

    private void handleClient() throws IOException {
        System.out.println("Client " + clientId + " connected.");

        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String clientMsg, reply;

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
            reply = console.readLine();
            dos.writeUTF(reply);
            dos.flush();

            if (reply.equalsIgnoreCase("stop")) {
                System.out.println("You ended conversation with Client " + clientId);
                break;
            }
        }

        dis.close();
        dos.close();
        clientSocket.close();

        System.out.println("Client " + clientId + " session ended. Ready for next client...");
    }
}