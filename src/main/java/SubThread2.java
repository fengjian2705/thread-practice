public class SubThread2 extends Thread {

    @Override
    public void run() {

        // 打印 1~100 之间的所有奇数
        for (int i = 0; i <= 100; i += 2) {
            System.out.println("------子线程 2 中: i = " + i);
        }
    }
}
