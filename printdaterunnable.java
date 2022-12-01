import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;


public class printdaterunnable implements Runnable {
    Socket sock;
    private void handlerconnection (Socket Sock){
        try {
            ObjectInputStream in = new ObjectInputStream (Sock.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(Sock.getOutputStream());
            String input = (String)in.readUTF();
            System.out.println(input);
            System.out.println("sending input");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date(); 
            System.out.println("Waiting 5 seconds");
            Thread.sleep(5000);
            out.writeUTF(formatter.format(date));
            out.flush();
            in.close();
            out.close();
            Sock.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    printdaterunnable(Socket Sock){
        sock=Sock;
    }
    public void run(){
        handlerconnection(sock);
    }
}