package LearnJVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2022-03-09
 * @Description:
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        while (true) {
            System.out.println(new Random().nextInt());
            list.add(new Random().nextInt());
        }
    }
}
