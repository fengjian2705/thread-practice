public class AccountThreadTest extends Thread {

    private static Demo demo = new Demo();
    private int balance;// 用于描述账户的余额

    public AccountThreadTest() {
    }

    public AccountThreadTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        test();
    }

    public /*synchronized*/ static void test(){
        System.out.println("线程" + Thread.currentThread().getName() + "已启动");
        synchronized (AccountThreadTest.class) {// 该类型对应的 Class 对象，由于类型时固定的，因此 Class 对象也是唯一的，因此可以实现同步
//        synchronized (new Demo()){
            // 1. 模拟从后台查询账户余额的过程
            int temp = 1000;//getBalance();
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
//            setBalance(temp);
        }
    }

    public static void main(String[] args) {

        AccountThreadTest att1 = new AccountThreadTest(1000);
        att1.start();

        AccountThreadTest att2 = new AccountThreadTest(1000);
        att2.start();

        System.out.println("主线程开始等待...");

        try {
            att1.join();
            att2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终的账户余额为: " + att1.getBalance());// 800
    }
}
