package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: Encode_535
 * @Author: LWQ
 * @Data: 2023/11/25 13:19
 * @Description: medium
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 *
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 *
 * 实现 Solution 类：
 *
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 *
 *
 * 示例：
 *
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 *
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 *
 *
 * 提示：
 *
 * 1 <= url.length <= 104
 * 题目数据保证 url 是一个有效的 URL
 */
public class Encode_535 {

    private static final String URL_PREFIX = "http://tinyurl.com/";
    private static final String CODE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private Map<String, String> map = new ConcurrentHashMap<>();

    /**
     * 通过：
     * 时间详情：2ms，击败 72.06%使用 Java 的用户
     * 内存详情：41.10MB，击败 26.35%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/4 22:35
     * @Param [longUrl]
     * @return java.lang.String
     * @Description:
     */
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (true) {
            StringBuilder stringBuilder = new StringBuilder(URL_PREFIX);
            for (int i = 0; i < 6; i++) {
                // Math.random() --> [0,1)
                stringBuilder.append(CODE.charAt((int)(Math.random() * 62)));
            }
            String shortURL = stringBuilder.toString();
            if (map.putIfAbsent(shortURL, longUrl) == null) {
                return shortURL;
            }
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));

    public static void main(String[] args) {
        Encode_535 target = new Encode_535();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = target.encode(longUrl);
        String result = target.decode(shortUrl);
        System.out.println(result);
    }
}
