package github.zhangq.secretstringtest.config;

/**
 * @author zhangqiuyang
 * Created on 2018/9/12.
 */
public class SecurityUtil {
    /**
     * encode
     *
     * @param value
     * @return
     */
    public static String encryptString(String value) {
        return new StringBuilder(value).reverse().toString();
    }

    /**
     * decode
     *
     * @param value
     * @return
     */
    public static String decryptString(String value) {
        return new StringBuilder(value).reverse().toString();
    }
}
