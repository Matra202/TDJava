
public class PoliteRunner extends Thread {
    private int tick = 1;
    private int num;
    public PoliteRunner(int num) {
    this.num = num;
    }
    public synchronized void run() {
    while (tick < 400000) {
        tick++;
        if ((tick % 50000) == 0){
            System.out.println("Thread #" + num + ", tick = " + tick);
            this.yield();            
        }
    }
    }
}
