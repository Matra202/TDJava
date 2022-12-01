import java.net.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;
public class testbox{
    public static void main (String[] args){
        
        if (args.length<1){return;}

        System.out.println("on a : " + Integer.valueOf(args[0]));

        try {
            ServerSocket recv = new ServerSocket(Integer.valueOf(args[0]));
            System.out.println("Waiting for accept");
            ObjectInputStream in = new ObjectInputStream (recv.accept().getInputStream());
            System.out.println("accpted");
            System.out.println((String)in.readUTF());
            System.out.println("readUTF done");
            Socket send = new Socket("localhost",Integer.valueOf(args[1]));
            System.out.println("Sock2 cree");

            ObjectOutputStream out = new ObjectOutputStream(send.getOutputStream());
            System.out.println("Objet cree");
            out.writeUTF("\n");
            out.flush();
            System.out.println("sending le backslash n");
            waiting();
            System.out.println((String)in.readUTF());
            while((String)in.readUTF()!="\n"){
                System.out.println((String)in.readUTF());
            }
            System.out.println("backslash n recu");

            DatagramSocket sockudp1 = new DatagramSocket(Integer.valueOf(args[2]));
            String message = "Connexion APP/IFACE";
            DatagramPacket outPacket1 = new DatagramPacket(message.getBytes(),
message.length(),Integer.valueOf(args[2]));
            DatagramPacket outPacket2 = new DatagramPacket(message.getBytes(),
message.length(),Integer.valueOf(args[3]));
            sockudp1.send(outPacket1);
            System.out.println("sending le packet au app");
            DatagramSocket sockudp2 = new DatagramSocket(Integer.valueOf(args[3]));
            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            sockudp2.receive(inPacket);
            while (!(inPacket.getData().equals(outPacket1.getData())))
            {
                sockudp1.send(outPacket1);
                sockudp2.receive(inPacket);
            }
            int clientPort = inPacket.getPort();
            


        } catch (Exception e) {
            // TODO: handle exception
        }
       

    }


public static void waiting () throws InterruptedException{
    try {
        wait();
    } catch (Exception e) {
        // TODO: handle exception
    }
}
}