package LearnBasic.ThreadShare;

import LearnBasic.ThreadShare.Data;

public class RunnableA implements Runnable{
    private final Data data;

    public RunnableA(Data data){
        this.data = data;
    }

    @Override
    public void run(){
        data.add();
        System.out.println("RunnableA：" + data.a);
    }
}
