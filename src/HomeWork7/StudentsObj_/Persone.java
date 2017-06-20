package HomeWork7.StudentsObj_;

/**
 * Created by Velev Vlad on 20.06.2017.
 */
public abstract class Persone {
    private String name;
    private String secondName;

    public Persone(){
        this.name = "N/A";
        this.secondName = "N/A";
    }

    public Persone(String name, String secondName){
        this.name = name;
        this.secondName = secondName;
    }
}
