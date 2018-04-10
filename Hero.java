public class Hero{
    private String gender = "";
    private String race = "";
    private String name = "";
    private int xp = 0;

    public void setName(String name){
        this.name = name;
    }
    public void setRace(String race){
        this.race = race;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void xpInc(int inc){
        this.xp += inc;
    }
    public void xpDec(int dec){
        this.xp += dec;
    }
    public String getName(){
        return this.name;
    }
    public String getRace(){
        return this.race;
    }
    public String getGender(){
        return this.gender;
    }
    public String getNameU(){
        return this.name.toUpperCase();
    }
    public String getRaceU(){
        return this.race.toUpperCase();
    }
    public String getGenderU(){
        return this.gender.toUpperCase();
    }
    public String getRaceL(){
        return this.race.toLowerCase();
    }
    public String getGenderL(){
        return this.gender.toLowerCase();
    }
    public int getXp(){
        return xp;
    }
    public boolean isHuman(){
        if (race.equals("Human"))
            return true;
        else
            return false;
    }
    public boolean isOrc(){
        if (race.equals("Orc"))
            return true;
        else
            return false;
    }
    public boolean isElf(){
        if (race.equals("Elf"))
            return true;
        else
            return false;
    }
    public boolean isDwarf(){
        if (race.equals("Dwarf"))
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
    public boolean isTransgender(){
        if (gender.equals("Transgender"))
            return true;
        else
            return false;
    }
}
