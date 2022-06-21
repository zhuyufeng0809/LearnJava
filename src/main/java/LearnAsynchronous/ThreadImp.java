package LearnAsynchronous;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author zhuyufeng
 * @version 1.0
 * @date 2021-03-15
 * @Description:
 */
public class ThreadImp {

    // 1.异步任务，返回future
    public static CompletableFuture<String> doSomethingOne(String encodedCompanyId) {
        // 1.1创建异步任务
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                // 1.1.1休眠1s，模拟任务计算
                try {
                    Thread.sleep(1000); } catch (InterruptedException e) {
                    e.printStackTrace(); }
                // 1.1.2 解密，并返回结果
                return encodedCompanyId;
            }
        });
    }
    // 2.开启异步任务，返回future
    public static CompletableFuture<String> doSomethingTwo(String companyId) {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                // 2.1 休眠3s，模拟计算
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 2.2 查询公司信息，转换为str，并返回
                return companyId + ":alibaba";
            }
        });
    }



    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> result = doSomethingOne("123").thenCompose(new Function<String, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(String s) {
                return doSomethingTwo("this is a string");
            }
        });
        CompletableFuture<String> result2 = doSomethingOne("123").thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {

                String r = null;
                try {
                    r = doSomethingTwo("this is a string").get();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return r;
            }
        });
        System.out.println(result.get());
    }
}
