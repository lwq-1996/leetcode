package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.temporal.ChronoField.*;

public class TestMain {

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(ISO_LOCAL_DATE)
                .appendLiteral('T')
                .appendValue(HOUR_OF_DAY, 2)
                .appendLiteral(':')
                .appendValue(MINUTE_OF_HOUR, 2)
                .optionalStart()
                .appendLiteral(':')
                .appendValue(SECOND_OF_MINUTE, 2)
                .toFormatter()));
    }

    /**
     * 返回不大于n的最大的2次幂
     *  n = 19, [00010011]
     *  1.找到最左边的1，然后把它右边所有0变为1 [00011111]
     *  2.把得到的数值加1，得到 [00100000]，即 00011111 + 00000001 = 00100000
     *  3.把得到的 00100000 右移一位，即可得出结果 00100000 >> 1 = 00010000
     * @param
     * @return
     */
    public static int test04(){
        int n = 19;
        // 先运行 n >> 1，后运行 n |=
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        return (n + 1) >> 1;
    }


    /**
     * 判断一个数是否是2的方幂
     */
    public static void test03(int n) {
        if (n > 0 && ((n&(n-1)) == 0)) {
            System.out.println("YES!");
        }
        System.out.println(2&(2-1));
        System.out.println(4&(4-1));
        System.out.println(6&(6-1));
        System.out.println(8&(8-1));
        System.out.println(1024&(1024-1));
    }

    public static void test01() {
        String cc = "fdsafa";
        System.out.println("\0");
        System.out.println(cc.contains("\0"));
        System.out.println(cc.contains("\n"));
        System.out.println("aaa\0" + "bbb");
        System.out.println(" ".equals('\0'));

        String s = "";
        System.out.println("".equals(s));
        String s1 = Objects.requireNonNull(s);

        List aa = new ArrayList<>();
        aa.add(1);
        aa.add(2);
        System.out.println(aa);
        int ss = 5/2;
        System.out.println(ss);
    }

    /**
     * 颠倒二进制位
     *  位运算分治
     * @param n
     * @return
     */
    public static int test02(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }
}
