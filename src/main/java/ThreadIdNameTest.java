public class ThreadIdNameTest extends Thread{

    public ThreadIdNameTest(String name) {

        super(name);// 表示调用父类的构造方法
    }

    @Override
    public void run() {

        System.out.println("子线程的编号是: "+ getId()+", 名称是: "+ getName());
        // 修改线程名称为 "rose"
        setName("rose");
        System.out.println("修改后子线程的编号是: "+ getId()+", 名称是: "+ getName());
    }

    public static void main(String[] args) {

        ThreadIdNameTest tint = new ThreadIdNameTest("jack");
        tint.start();

        // 获取当前正在执行线程的引用，当前正在执行的线程是主线程，也就是获取主线程的引用
        Thread t1 = Thread.currentThread();
        System.out.println("主线程的编号是: "+ t1.getId()+", 名称是: "+ t1.getName());
    }
}
