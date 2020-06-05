package pers.tavish.jcip.ch5buildingblocks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 程序清单5-12
public class Preloader {

    ProductInfo loadProductInfo() {
        return null;
    }

    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(this::loadProductInfo);
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws InterruptedException {

        try {
            return future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    interface ProductInfo {
    }
}
