
package application;

import java.util.ArrayList;


public class Player {
    //Instance Variables:
    private String name;
    private String surname;
    private Date birthDate;
    private ArrayList<String> clubs;
    
    //Constructor:
    public Player(String name , String surname , Date birthDate , ArrayList<String> clubs) {
        this.name =name;
        this.surname =surname;
        this.birthDate =birthDate;
        this.clubs =clubs;
    }
    
    //Getter & Setters:

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getClubs() {
        return clubs;
    }

    
    
    
    
    
    public static String dateToNumericString(Date d) {
        return d.getDay() + "/" + d.getMonth() + "/" + d.getYear();
    }
    
    @Override
    public String toString() {
        String stringClub = String.join("," , clubs);
        return name + "," + surname + "," + dateToNumericString(birthDate) + ","+ stringClub;
    }


    
    
}
