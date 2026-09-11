public class ThreadTest {

    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();

        Thread t2=new Thread(new MyTask());
        t2.start();

        Thread t3=new Thread( ()-> {
            System.out.println("lambda thread");
        }  );
        t3.start();
    }
}
