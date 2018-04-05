public class Hero{
private String gender = "";

    public static final String RESET    = "\u001B[0m";
    public static final String RED      = "\u001B[31m";
    public static final String GREEN    = "\u001B[32m";
    public static final String YELLOW   = "\u001B[33m";
    public static final String BLUE     = "\u001B[34m";
    public static final String PURPLE   = "\u001B[35m";
    public static final String CYAN     = "\u001B[36m";
    public static final String WHITE    = "\u001B[37m";

    private String race = "";
    private String name = "";

    public void setName(String name){
        this.name = name;
    }

    public void setRace(String race){
        this.race = race;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getName(int c){
        return colorize(this.name, c);
    }
    public String getRace(int c){
        return colorize(this.race, c);
    }
    public String getGender(int c){
        return colorize(this.gender, c);
    }
    public String getNameU(int c){
        return colorize(this.name.toUpperCase(), c);
    }
    public String getRaceU(int c){
        return colorize(this.race.toUpperCase(), c);
    }
    public String getGenderU(int c){
        return colorize(this.gender.toUpperCase(), c);
    }
    public boolean isHuman(){
        if (race.equals("Human"))
            return true;
        else
            return false;
    }
    public boolean isOrch(){
        if (race.equals("Human"))
            return true;
        else
            return false;
    }
    public boolean isElf(){
        if (race.equals("Human"))
            return true;
        else
            return false;
    }
    public boolean isDwarf(){
        if (race.equals("Human"))
            return true;
        else
            return false;
    }
    public boolean isMale(){
        if (gender.equals("Male"))
            return true;
        else
            return false;
    }
    public boolean isFemale(){
        if (gender.equals("Female"))
            return true;
        else
            return false;
    }
    public String colorize(String s, int c){
        String pickedColor = "";
        if (c == 1)
            return "<html><font color = red>"+s+"</font></html>";
        else if (c == 1)
            return GREEN+s+RESET;
        else if (c == 2)
            return YELLOW+s+RESET;
        else if (c == 3)
            return BLUE+s+RESET;
        else if (c == 4)
            return PURPLE+s+RESET;
        else if (c == 5)
            return CYAN+s+RESET;
        else if (c == 6)
            return WHITE+s+RESET;
        else
            return s;
    }
}
