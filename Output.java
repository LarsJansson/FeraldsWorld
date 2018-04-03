import java.util.concurrent.TimeUnit;

public class Output{
    public void output(){
        System.out.println("Output> No string provided");
    }
    public void output(String str) throws Exception{
        System.out.println(str);
        TimeUnit.SECONDS.sleep(0);
    }
    public void output(String str, int delay) throws Exception{
        System.out.println(str);
        TimeUnit.SECONDS.sleep(delay);
    }
}
