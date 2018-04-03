import java.util.concurrent.TimeUnit;

public class Output{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    public void output(){
        System.out.println("Output> No string provided");
    }
    public void output(String str) throws Exception{
        System.out.println(str);
    }
    public void output(String str, int bd, int ad, boolean remove) throws Exception{
        TimeUnit.SECONDS.sleep(bd);
        if(remove){
            System.out.print("\r                                                             ");
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
    public void outputC(String str, int bd, int ad, boolean remove, int color) throws Exception{
        String pickedColor = "";
        if(color == 1)
            pickedColor = RED;
        else if(color == 2)
            pickedColor = PURPLE;
        else if(color == 0)
            pickedColor = RESET;
        else
            pickedColor = "";

        TimeUnit.SECONDS.sleep(bd);
        if(remove){
            System.out.print("\r                                                             ");
            System.out.print("\r"+pickedColor+str+RESET);
        }else{
            System.out.print(pickedColor+str+RESET);
        }
        TimeUnit.SECONDS.sleep(ad);
    }
}
