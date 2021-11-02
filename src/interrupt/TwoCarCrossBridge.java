/**
 * @(#)TwoCarCrossBridge.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package interrupt;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author guochenghui
 */
public class TwoCarCrossBridge {

    public static void main(String[] args) {

        Thread carTwo = new Thread(() -> {
            System.out.println("卡丁2号 准备过桥");
            System.out.println("发现1号在过，开始等待");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("卡丁2号 开始过桥");
            }
            System.out.println("卡丁2号 过桥完毕");
        });


        Thread carOne = new Thread(() -> {
            System.out.println("卡丁1号 开始过桥");
            int timeSpend = new Random().nextInt(500) + 1000;
            try {
                TimeUnit.MILLISECONDS.sleep(timeSpend);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("卡丁1号 过桥完毕 耗时:" + timeSpend);
//            System.out.println("卡丁2号的状态" + carTwo.getState());
            carTwo.interrupt();
        });

        carOne.start();
        carTwo.start();

    }

}