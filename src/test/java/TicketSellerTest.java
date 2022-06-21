/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2022-06-20
 * @Description:
 */

import org.junit.jupiter.api.*;

@DisplayName("TicketSellerTest测试")
public class TicketSellerTest {

    // 定义待测试类的实例
    private TicketSeller ticketSeller;

    // 定义在整个测试类开始前执行的操作
    // 通常包括全局和外部资源(包括测试性)的创建和始化
    @BeforeAll
    public static void init(){
        //...
    }

    // 定义在整个测试类完成后执行的操作
    // 通常包括全局和外部资源的释放和销毁
    @AfterAll
    public static void cleanup(){
        //...
    }

    // 定义在每个测试用例开始前执行的操作
    // 通常包括基础数据和运行环境的准备
    @BeforeEach
    public void create() {
        this.ticketSeller = new TicketSeller();
        //...
    }

    // 定义在每个测试用例完成后执行的操作
    // 通常包括运行环境的清理
    @AfterEach
    public void destroy() {
        //...
    }

    @Test
    @Tag("fast")
    @DisplayName("测试某个方法")
    public void shouldReduceInventoryWhenTicketSoldOut() {
        //...
    }

    @Test
    @Tag("slow")
    @DisplayName("测试某个方法")
    public void shouldSuccessWhenBuy20TicketsOnce() {

    }

    @Test
    @DisplayName("测试某个方法")
    public void shouldThrowExceptionWhenNoEnoughInventory() {
        //...
    }

    // Disabled注释将禁用测试用例
    // 该测试用例会出现在最终的报告中，但不会被执行
    @Disabled
    @Test
    @DisplayName("测试某个方法")
    public void shouldIncreaseInventoryWhenTicketRefund() {
        //...
    }
}
