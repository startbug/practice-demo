package base1;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/24 17:42
 */
public class TestDemo3 {

    static int count;

    // 反编译
    // 1.javac base1.TestDemo3.java
    // 2.javap -v base1.TestDemo3.class
    public static void increment() {
        synchronized (TestDemo3.class) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }


}
