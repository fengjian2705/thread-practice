public class ThreadPriorityTest extends Thread {

    @Override
    public void run() {

//        System.out.println("子线程的优先级: " + getPriority());// 5
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程中: i = " + i);
        }
    }

    public static void main(String[] args) {

        ThreadPriorityTest tpt = new ThreadPriorityTest();
        // 设置子线程优先级
        tpt.setPriority(Thread.MAX_PRIORITY);
        tpt.start();

        Thread t1 = Thread.currentThread();
//        System.out.println("主线程的优先级: " + t1.getPriority());// 5 普通的优先级
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程中: i = " + i);
        }
    }
}
