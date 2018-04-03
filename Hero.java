public class Hero{
    private String gender = "";
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
}
