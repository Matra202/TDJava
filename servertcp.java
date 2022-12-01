import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;
public class servertcp {

    public static void main(String[] args) {
        try {
            ServerSocket servSocket = new ServerSocket(1234);
            System.out.println("Awaiting Connection");
            while (true){
                Socket Sock= servSocket.accept();
                System.out.println("fils crée");
                printdaterunnable pdr1 = new printdaterunnable(Sock);
                Thread t1 = new Thread(pdr1);
                t1.start();
            }
            
        } catch (Exception e) {
            System.out.println ("Error");
        }
    }
}
