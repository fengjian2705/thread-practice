import java.util.concurrent.locks.ReentrantLock;

public class AccountRunnableTest implements Runnable {

    private ReentrantLock lock = new ReentrantLock();// 准备了一把锁
    private Demo demo = new Demo();
    private int balance;// 用于描述账户的余额

    public AccountRunnableTest() {
    }

    public AccountRunnableTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public /*synchronized*/ void run() {
        // 开始加锁
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "已启动");
        // 由源码可知：最终是 account 对象来调用 run 方法，因此当前正在调用的对象就是 account，也就是 this 就是 account
//        synchronized (this) {
//        synchronized (new Demo()){
        // 1. 模拟从后台查询账户余额的过程
        int temp = getBalance();
        // 2. 模拟取款 200 元的过程
        if (temp >= 200) {
            System.out.println("正在出钞，请稍后");
            temp -= 200;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("请取走您的钞票 !");
        } else {
            System.out.println("余额不足，请核对您的账户余额 !");
        }
        // 3. 模拟将最新的账户余额写入到后台
        setBalance(temp);
//        }
        lock.unlock();
    }

    public static void main(String[] args) {

        AccountRunnableTest account = new AccountRunnableTest(1000);
        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);
        t1.start();
        t2.start();

        System.out.println("主线程开始等待...");
        try {
            t1.join();
//            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终的账户余额为: " + account.getBalance());// 800
    }
}

class Demo {

    public static void main(String[] args) {
    }
}
