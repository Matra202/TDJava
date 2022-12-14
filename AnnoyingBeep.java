import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;
/**
* Schedule a task that executes once every second.
*/
public class AnnoyingBeep {
    Toolkit toolkit;
    Timer timer;
    long time;
    public AnnoyingBeep() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        time = System.currentTimeMillis();
        timer.scheduleAtFixedRate(new RemindTask(),
        5*1000, //initial delay
        1*1000); //subsequent rate
    }
    class RemindTask extends TimerTask {
        int numWarningBeeps = 3;
        public void run() {
            if (numWarningBeeps > 0 & (System.currentTimeMillis()-time)<= 5000) {
                toolkit.beep();
                System.out.println("Beep!");
                numWarningBeeps--;
                time = System.currentTimeMillis(); 
            } else {
                toolkit.beep();
                System.out.println("Time's up!");
                //timer.cancel(); //Not necessary because we call System.exit
                System.exit(0); //Stops the AWT thread (and everything else)
            }
        }
    }
    public static void main(String args[]) {
        System.out.println("About to schedule task.");
        new AnnoyingBeep();
        System.out.println("Task scheduled.");
    }
}