class MyThread extends Thread {
    public MyThread (String s) {
        super(s);
    }
    public void run() {
        System.out.println("Hello, I am "+ getName());
    }
}
    public class td1 {
        public static void main (String arg[]) {
            int n = Integer.parseInt(arg[0]);
            for (int i=0; i<n;i++){
                MyThread ti;
                ti = new MyThread ("Thread #"+Integer.toString(i) );
                ti.start();
            }
            
        }
    }