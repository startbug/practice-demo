/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/25 9:59
 */
public class Code06_PrintB {

    public static void main(String[] args) {
        int num = 3;

        print(num);
    }

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & 1 << i) == 0 ? "0" : "1");
        }
        System.out.println();
    }

}
