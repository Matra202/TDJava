import java.net.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;
public class ipbox{
    public static void main (String[] args){

        if (args.length<1){return;}

        System.out.println("on a : " + Integer.valueOf(args[1]));


        try {
            ServerSocket recv_conf = new ServerSocket(Integer.valueOf(args[0]));
            Socket send_conf = new Socket("localhost",Integer.valueOf(args[1]));
            DatagramSocket app = new DatagramSocket(Integer.valueOf(args[2]));
            DatagramSocket iface = new DatagramSocket(Integer.valueOf(args[3]));

            ObjectOutputStream out = new ObjectOutputStream(send_conf.getOutputStream());
            out.writeUTF("Ready to test");
            out.flush();
            System.out.println("ready to test sent");
            ObjectInputStream in = new ObjectInputStream (recv_conf.accept().getInputStream());
            System.out.println("Objet accepte");

            System.out.println((String)in.readUTF());
            System.out.println("UTF lu");

            out.writeUTF((String)in.readUTF());
            out.flush();
            notifying();
            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            app.receive(inPacket);
            int clientPort = inPacket.getPort();
            String message = new String(inPacket.getData(), 0, inPacket.getLength());
            System.out.println(message);
            DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(),
         clientPort);
            app.send(outPacket);
        } catch (Exception e) {
            // TODO: handle exception
        }
       

    }


public static void notifying () {
    notify();
}
}