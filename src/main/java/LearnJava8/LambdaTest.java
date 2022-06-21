package LearnJava8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2021-03-14
 * @Description:
 */
public class LambdaTest<O> {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);

        //new LambdaTest<String>().testL((a) -> a, "2");
    }

    void testL(testFunctionalInterface<O> a, O p){
        System.out.println(a.tLambda( p));
    }
}
