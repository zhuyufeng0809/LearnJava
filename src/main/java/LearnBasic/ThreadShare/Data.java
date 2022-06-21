package LearnBasic.ThreadShare;

public class Data {
    int a = 1;
    synchronized public void add(){
        a += 1;
    }
}