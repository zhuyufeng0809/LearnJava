package LearnThread.char08;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class XThreadFactoryUsage {
    final static ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 4,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(8),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        final ThreadFactory tf = new XThreadFactory("worker");
        executor.setThreadFactory(tf);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }
}