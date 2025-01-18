package arithmetic_pattern;

/**
 * @Projectname: arithmetic
 * @Filename: GCS
 * @Author: LWQ
 * @Data: 2024/4/4 21:16
 * @Description: 计算最大公约数
 */

public class Gcs {

    /**
     * @Author LWQ
     * @Date 2024/4/4 21:18
     * @Param [a, b]
     * @return java.lang.Integer
     * @Description: 辗转相除法
     */
    private static Integer gcs_1(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }

        return b;
    }

    /**
     * @Author LWQ
     * @Date 2024/4/22 12:26
     * @Param [a, b]
     * @return java.lang.Integer
     * @Description: 更相减损法
     */
    private static Integer gcs_2(int a, int b) {
        int max = a > b ? a : b;
        int min = a > b ? b : a;

        if (max % min == 0) {
            return min;
        }

        return gcs_2((max - min), min);
    }

    public static void main(String[] args) {
        int gcs = Gcs.gcs_2(10, 4);
        System.out.println(gcs);
    }
}

