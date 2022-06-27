/**
 *<h1>生产者线程，不断的生产产品</h1>
 *@author 风间
 *@since  2022/6/28
 */
public class ProducerThread extends Thread{

    // 声明一个仓库类型的引用作为成员变量，为了能调用仓库中的生产方法，合成复用原则
    private StoreHouse storeHouse;

    // 为了确保两个线程共用一个仓库
    ProducerThread(StoreHouse storeHouse){
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {

        while (true) {
            storeHouse.produceProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
