package LearnThread.char08;

import java.util.concurrent.ThreadFactory;

public class XThreadFactory implements ThreadFactory {
    // 所创建的线程的线程名前缀
    private final String namePrefix;

    public XThreadFactory(String name) {
        this.namePrefix = name;
    }

    protected Thread doMakeThread(final Runnable r) {
        return new Thread(r);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = doMakeThread(r);
        t.setName(namePrefix);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }

}