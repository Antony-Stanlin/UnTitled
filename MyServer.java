import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MyServer {
    public static void main(String args[]) throws Exception {
        
        ServerSocket serverSocket = new ServerSocket(3333);
        System.out.println("Server started and waiting for a client...");

       
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        
        while (!str.equals("stop")) {
            
            str = dataInputStream.readUTF();
            System.out.println("Client says: " + str);
            
            // Read response from server console and send to client
            str2 = bufferedReader.readLine();
            dataOutputStream.writeUTF(str2);
            dataOutputStream.flush();
        }

        
        dataInputStream.close();
        socket.close();
        serverSocket.close();
    }
}




