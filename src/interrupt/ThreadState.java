/**
 * @(#)ThreadState.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author guochenghui
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("1- " + thread.getState());
        thread.start();
        System.out.println("2- " + thread.getState());

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("产生中断" + e.getMessage());
        }

        System.out.println("3- " + thread.getState());
    }
}