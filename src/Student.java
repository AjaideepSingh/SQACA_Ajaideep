import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private Topic topic;

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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Student(String firstName, String lastName, Topic topic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", topic=" + topic +
                '}';
    }
}