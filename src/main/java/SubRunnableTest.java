public class SubRunnableTest {

    public static void main(String[] args) {

        SubRunnable1 st1 = new SubRunnable1();
        SubRunnable2 st2 = new SubRunnable2();

        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st2);

        t1.start();
        t2.start();

        System.out.println("主线程开始等待...");

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程等待结束 !");

    }
}
