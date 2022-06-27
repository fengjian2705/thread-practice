/**
 * <h1>仓库类</h1>
 *
 * @author 风间
 * @since 2022/6/28
 */
public class StoreHouse {

    private int cnt = 0;// 用于记录产品数量

    public synchronized void produceProduct() {

        notify();
        if (cnt < 10) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在生产第" + (cnt + 1) + "个产品...");
            cnt++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduce() {

        notify();
        if (cnt > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "消费第" + cnt + "个产品");
            cnt--;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
