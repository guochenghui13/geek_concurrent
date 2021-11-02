package Lock和Condition; /**
 * @(#)X.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guochenghui
 */
public class X {
    private final Lock lock = new ReentrantLock();
    int value = 0;
    public void addOne(){
        try {
            lock.lock();
            value++;
        } catch (Exception e) {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        X x = new X();

        new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                x.addOne();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                x.addOne();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                x.addOne();
            }
        }).start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("value的值：" + x.value);
    }
}