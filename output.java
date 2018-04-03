import java.util.concurrent.TimeUnit;

public class output{
    public output(){
        System.out.println("Output> No string provided");
    }
    public output(String str) throws Exception{
        System.out.println(str);
        TimeUnit.SECONDS.sleep(0);
    }
    public output(String str, int delay) throws Exception{
        System.out.println(str);
        TimeUnit.SECONDS.sleep(delay);
    }
}
