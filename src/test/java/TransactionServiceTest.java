import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2022-06-21
 * @Description:
 */
@DisplayName("TransactionService测试")
public class TransactionServiceTest {

    @Nested
    @DisplayName("UserTransaction测试")
    class UserTransactionTest {

        @Nested
        @DisplayName("Positive测试")
        class PositiveCase {

            @Test
            @DisplayName("shouldPassCheckWhenParameter测试")
            public void shouldPassCheckWhenParameterValid() {
                //...
            }
        }

        @Nested
        @DisplayName("Negative测试")
        class NegativeCase {
            //...
        }
    }

    @Nested
    @DisplayName("CompanyTransaction测试")
    class CompanyTransactionTest {
        //...
    }
}
