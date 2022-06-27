public class ThreadTest {

    public static void main(String[] args) {

        // 1. 使用无参构造方式构造 Thread 类型的对象
        Thread t1 = new Thread();
        // 2. 调用 run 方法进行测试
        // 由源码可知：由于成员变量 target 的数值为 null，因此条件 if(target !=null) 不成立，
        // 跳过{}中的代码不执行
        t1.run();
        // 3. 打印一句话
        System.out.println("我想看看你到底是否真的啥也不干 !");
    }
}
