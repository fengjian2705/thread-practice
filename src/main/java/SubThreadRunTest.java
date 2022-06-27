public class SubThreadRunTest {

    public static void main(String[] args) {

        // 1. 声明 Thread 类型的引用执行子类类型的对象
        Thread t1 = new SubThreadRun();
        // 2. 调用 run 方法测试，本质上相当于对普通成员方法的调用，
        // 因此执行流程就是 run 方法的代码执行完毕后才能继续向下执行
//        t1.run();
        // 用于启动线程，Java 虚拟机会自动调用该线程类中的 run 方法
        // 相当于又启动了一个线程
        t1.start();

        // 打印 1~20 之间的所有整数
        for (int i = 1; i <= 20; i++) {
            System.out.println("--------main 方法中: i = " + i);// 1 2 ... 20
        }
    }
}
