package LearnTest;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2022-06-20
 * @Description:
 */
public class Factorial {
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
