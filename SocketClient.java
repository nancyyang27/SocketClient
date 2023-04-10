import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SocketClient <server> <port> [message]");
            System.exit(1);
        }

        String server = args[0];
        int port = Integer.parseInt(args[1]);

        String message = "";
        if (args.length > 2) {
            message = args[2];
        }

        try {
            Socket socket = new Socket(server, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            out.println(message);

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }
}






