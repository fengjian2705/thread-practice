public class SubRunnableRunTest {

    public static void main(String[] args) {

        // 1. 创建自定义类型对象，也就是实现 Runnable 接口类的对象
        SubRunnableRun srr = new SubRunnableRun();
        // 2. 使用该对象作为实参构造 Thread 类型的对象
        // 由源码可知：经过构造方法的调用之后，Thread 类中的成员变量 target 的数值是 srr
        Thread t1 = new Thread(srr);
        // 3. 使用 Thread 类型的对象调用 start 方法
        // 若使用 Runnable 引用构造了线程对象，调用该 run 方法时最终调用接口中的版本
        // 由 run 方法的源码可知：  if (target != null) {
        //            target.run();
        //        }
        // 此时 target 的数值不为空这个条件成立，执行 target.run() 的代码，也就是 srr.run() 的代码
        t1.start();

        // 打印 1~20 之间的所有整数
        for (int i = 1; i <= 20; i++) {
            System.out.println("-------main 方法中: i = " + i);// 1 2 ... 20
        }
    }
}

