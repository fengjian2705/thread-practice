public class StoreHouseTest {

    public static void main(String[] args) {

        // 创建仓库类对象
        StoreHouse storeHouse = new StoreHouse();

        // 创建线程类对象并启动
        ProducerThread t1 = new ProducerThread(storeHouse);
        ConsumerThread t2 = new ConsumerThread(storeHouse);
        t1.start();
        t2.start();

    }
}
