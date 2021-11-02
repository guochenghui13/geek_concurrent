/**
 * @(#)VolatileExample.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author guochenghui
 */

// 以下代码来源于【参考1】
class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
            // 这里x会是多少呢？
            System.out.println(this.x);
        }
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();

        new Thread(()->volatileExample.writer()).start();
        new Thread(()->volatileExample.reader()).start();
    }
}