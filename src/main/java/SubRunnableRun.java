public class SubRunnableRun implements Runnable{

    public void run() {

        // 打印 1~20 之间的所有整数
        for (int i = 1; i <= 20; i++) {
            System.out.println("run 方法中: i = " + i);// 1 2 ... 20
        }
    }
}
