package seedu.duke.recordtype;

public class User {
    private String name;
    private Integer number ;
    private String email;

    public User(String name, Integer number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public Integer getNumber(){
        return this.number;
    }

    public String getEmail(){
        return this.email;
    }

}
