import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class portscanner {


    public static void main(String[] args) {
            System.out.println("Scanning ports");
            boolean found = false;
            int i = 1000;
            while (!found & i<1500){
                try (Socket Sock= new Socket ("localhost",i)){
                    System.out.println("Server is listening on port " + i);
                    found = true;
                    Sock.close();
                } catch (Exception e) {
                    System.out.println("Server is not listening on port " +i);
                } 
                
                i++;  
            }
    }
}