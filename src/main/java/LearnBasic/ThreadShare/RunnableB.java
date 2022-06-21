package LearnBasic.ThreadShare;

import LearnBasic.ThreadShare.Data;

public class RunnableB implements Runnable{
    private final Data data;

    public RunnableB(Data data){
        this.data = data;
    }

    @Override
    public void run(){
        data.add();
        System.out.println("RunnableB：" + data.a);
    }
}
