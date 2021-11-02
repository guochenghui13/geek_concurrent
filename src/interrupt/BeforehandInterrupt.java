/**
 * @(#)BeforehandInterrupt.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package interrupt;

/**
 * @author guochenghui
 */
public class BeforehandInterrupt {
    public static void main(String[] args) {

//        Thread.currentThread().interrupt();

        try {
            System.out.println("开始睡眠");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("发生中断");
        }

        System.out.println("结束睡眠");

    }
}