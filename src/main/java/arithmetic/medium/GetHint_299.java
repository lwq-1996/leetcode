package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: GetHint_299
 * @Author: LWQ
 * @Data: 2023/12/4 22:37
 * @Description: medium
 */

/**
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 *
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 *
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 *
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：secret = "1807", guess = "7810"
 * 输出："1A3B"
 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1807"
 *   |
 * "7810"
 * 示例 2：
 *
 * 输入：secret = "1123", guess = "0111"
 * 输出："1A1B"
 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 *
 *
 * 提示：
 *
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret 和 guess 仅由数字组成
 */
public class GetHint_299 {

    /**
     * 通过：
     * 时间详情：1ms，击败 100.00%使用 Java 的用户
     * 内存详情：40.10MB，击败 80.87%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/5 12:40
     * @Param [secret, guess]
     * @return java.lang.String
     * @Description: 分别统计出现次数
     */
    public String getHint(String secret, String guess) {
        // 题目数据 secret.length == guess.length
        int length = secret.length();
        int[] bull = new int[10];
        int[] cow_sec = new int[10];
        int[] cow_gue = new int[10];
        for (int i = 0; i < length; i++) {
            char sec = secret.charAt(i);
            char gue = guess.charAt(i);
            if (sec == gue) {
                bull[sec - '0'] = ++bull[sec - '0'];
            } else {
                cow_sec[sec - '0'] = ++cow_sec[sec - '0'];
                cow_gue[gue - '0'] = ++cow_gue[gue - '0'];
            }
        }

        int bullNum = 0, cowNum = 0;
        for (int i = 0; i < 10; i++) {
            bullNum += bull[i];
            // 以最短为统计准则
            cowNum += Math.min(cow_sec[i], cow_gue[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(bullNum).append("A").append(cowNum).append("B").toString();
    }

    /**
     * 通过：
     * 时间详情：1ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.69MB，击败 99.10%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/5 12:45
     * @Param [secret, guess]
     * @return java.lang.String
     * @Description: 省略公牛统计数组空间，直接计数
     */
    public String getHint2(String secret, String guess) {
        // 题目数据 secret.length == guess.length
        int length = secret.length();
        // 公牛数直接统计即可，无需额外空间记录
        int bullNum = 0, cowNum = 0;
        int[] cow_sec = new int[10];
        int[] cow_gue = new int[10];

        for (int i = 0; i < length; i++) {
            char sec = secret.charAt(i);
            char gue = guess.charAt(i);
            if (sec == gue) {
                bullNum++;
            } else {
                cow_sec[sec - '0']++;
                cow_gue[gue - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            // 以最短为统计准则
            cowNum += Math.min(cow_sec[i], cow_gue[i]);
        }

        return bullNum + "A" + cowNum + "B";
    }

    public static void main(String[] args) {
        GetHint_299 target = new GetHint_299();
        String secret = "1807", guess = "7810";
        String result = target.getHint(secret, guess);
        System.out.println(result);
    }
}
