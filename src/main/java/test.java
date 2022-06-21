import java.util.Arrays;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2021-06-01
 * @Description:
 */
public class test {

    private String filter;
    public static void main(String[] args) {
        test testA = new test();
        testA.setFilter("my");
        testA.printFilter();
    }

    private void setFilter(String filter) {
        this.filter = filter;
    }

    private void printFilter() {
        System.out.println(this.filter);
    }
}
