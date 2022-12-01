import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class client {


    public static void main(String[] args) {
        try {
            System.out.println("Trying to build socket");
            Socket Sock= new Socket ("localhost",1234);
            System.out.println("socket built");
            ObjectOutputStream out = new ObjectOutputStream(Sock.getOutputStream());
            System.out.println("output ok");
            ObjectInputStream in = new ObjectInputStream (Sock.getInputStream());
            
            System.out.println("sending input");
            out.writeUTF("Heure?");
            out.flush();
            String input = in.readUTF();
            System.out.println(input);
        
            in.close();
            out.close();
            Sock.close();
        } catch (Exception e) {
            System.out.println ("Error");
        }
    }
}