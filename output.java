public class output{
    public output(){
        System.out.println("Output> No string provided");
    }
    public output(String str){
        System.out.println(str);
        TimeUnit.SECONDS.sleep(0);
    }
    public output(String str, int delay){
        System.out.println(str);
        Timunit.SECONDS.sleep(delay);
    }
}
