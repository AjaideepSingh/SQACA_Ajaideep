import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Topic> topics;

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    public Student(String firstName, String lastName, ArrayList<Topic> topics) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Student: " +
                "first Name: " + firstName + '\'' +
                ", last Name: " + lastName + '\'' +
                ", topics: " + topics +
                '}';
    }
}