import java.util.concurrent.TimeUnit;

public class Output{
    public void output(){
        System.out.println("Output> No string provided");
    }
    public void output(String str) throws Exception{
        System.out.println(str);
    }
    public void output(String str, int bd, int ad, boolean remove) throws Exception{
        TimeUnit.SECONDS.sleep(bd);
        if(remove){
            System.out.print("\r                                              ");
            System.out.print("\r"+str);
        }else{
            System.out.print(str);
        }
        TimeUnit.SECONDS.sleep(ad);
    }
    public void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
