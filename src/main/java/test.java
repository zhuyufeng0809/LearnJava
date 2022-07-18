import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2021-06-01
 * @Description:
 */
public class test {

    public static void main(String[] args) {
        String a = "strA";
        String b = "strB";

        List<String> result = new ArrayList<>();

        result.add(a);



        String r = result.stream()
                .collect(Collectors.joining(" AND "));

    }
}
