package LearnJava8;

import java.util.Optional;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2021-03-13
 * @Description:
 */
public class OptionalTest {
    public static void main(String[] args){

        System.out.println(sum(getNullInteger(), getNotNullInteger()));
    }

    private static Integer sum(Integer a, Integer b){
        Integer value1 = Optional.ofNullable(a).orElse(0);
        Integer value2 = Optional.ofNullable(b).orElse(0);
        return Optional.of(value1 + value2).orElse(0);
    }

    private static Integer getNullInteger(){
        return null;
    }

    private static Integer getNotNullInteger(){
        return 10;
    }
}
