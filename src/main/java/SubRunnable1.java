public class SubRunnable1 implements Runnable{

    @Override
    public void run() {
        // 打印 1~100 之间的所有奇数
        for (int i = 0; i <= 100; i += 1) {
            System.out.println("------子线程 1 中: i = " + i);
        }
    }
}
