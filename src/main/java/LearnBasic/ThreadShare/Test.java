package LearnBasic.ThreadShare;

public class Test {
    public static void main(String[] args) {
        final Data data = new Data();
        new Thread(new RunnableA(data)).start();
        new Thread(new RunnableB(data)).start();
    }
}
