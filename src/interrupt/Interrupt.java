/**
 * @(#)Interrupt.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author guochenghui
 */
public class Interrupt {
    public static void main(String[] args) {
        Thread carOne = new Thread(() -> {
            long startMills = System.currentTimeMillis();
            while (System.currentTimeMillis() - startMills < 10) {
//                if (Thread.currentThread().isInterrupted()) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("向左开1米");
                } else {
                    System.out.println("往前开1米");
                }
            }
        });

        carOne.start();

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程睡眠结束");
        carOne.interrupt();

    }
}