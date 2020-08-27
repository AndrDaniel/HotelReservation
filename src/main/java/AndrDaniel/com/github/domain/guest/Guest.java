package AndrDaniel.com.github.domain.guest;

public class Guest {

    //CRUD//

    //Create
    //Read
    //Update
    //Delete
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;
    Guest(int id, String firstName, String lastName, int age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    public int getId() {
        return id;
    }
    public String getInfo() {
        return String.format("%d %s %s (%d) (%s)",this.id, this.firstName, this.lastName, this.age, this.gender);
    }
    String toCSV() {
        return String.format("%s,%s,%s,%d,%s%s",
                this.id,
                this.firstName,
                this.lastName,
                this.age,
                this.gender,
                System.getProperty("line.separator"));
    }
}