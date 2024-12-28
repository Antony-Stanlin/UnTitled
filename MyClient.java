import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MyClient {
    public static void main(String args[]) throws Exception {
        
        Socket socket = new Socket("192.168.8.101", 3333);
        System.out.println("Connected to server");

       
        DataInputStream dataInputStream= new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
       
        while (!str.equals("stop")) {
            
            str = bufferedReader.readLine();
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();

            
            str2 = dataInputStream.readUTF();
            System.out.println("Server says: " + str2);
        }

        dataOutputStream.close();
        socket.close();
    }
}
