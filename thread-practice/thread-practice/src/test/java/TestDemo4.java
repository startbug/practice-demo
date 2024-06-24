import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/24 17:42
 */
public class TestDemo4 {

    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("AAA", 1);
        String oldValue = reference.getReference();
        int oldStamp = reference.getStamp();

        boolean result1 = reference.compareAndSet("AAA", "BBB", oldStamp, oldStamp + 1);
        System.out.println("result1=" + result1);
        boolean result2 = reference.compareAndSet("BBB", "CCC", oldStamp, oldStamp + 2);
        System.out.println("result2=" + result2);
    }


}
