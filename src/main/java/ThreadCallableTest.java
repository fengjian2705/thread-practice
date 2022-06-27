import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallableTest implements Callable {

    @Override
    public Object call() throws Exception {

        // 计算 1~10000 之间的累加和并打印返回
        int sum = 0;
        for (int i = 0; i <= 10000; i++) {
            sum += i;
        }
        System.out.println("计算的累加和是: " + sum);
        return sum;
    }

    public static void main(String[] args) {

        ThreadCallableTest tct = new ThreadCallableTest();
        FutureTask ft = new FutureTask<>(tct);
        Thread t1 = new Thread(ft);
        t1.start();

        Object obj = null;
        try {
            obj = ft.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程处理方法返回的值是: " + obj);
    }
}
