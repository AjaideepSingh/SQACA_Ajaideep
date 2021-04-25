
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class POJOTests {
    @Test
    void rubric() {
        Rubric rubric = new Rubric("design",5);
        assertEquals("design", rubric.getCriteria());
        assertEquals(5, rubric.getValue());
    }

    @Test
    void student() {
        Student student = new Student();
        student.setFirstName("Ajai");
        student.setLastName("Singh");
        Topic topic = new Topic();
        topic.setTopicName("OOSD");
        Rubric rubric = new Rubric("implementation", 3);
        Rubric rubric1 = new Rubric("testing", 2);
        Rubric rubric2 = new Rubric("design", 5);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        topic.setRubrics(rubrics);
        student.setTopic(topic);
        assertEquals("Ajai",student.getFirstName());
        assertEquals("Singh",student.getLastName());
    }

    @Test
    void topic() {
        Topic topic = new Topic();
        topic.setTopicName("OOSD");
        Rubric rubric = new Rubric("implementation", 3);
        Rubric rubric1 = new Rubric("testing", 2);
        Rubric rubric2 = new Rubric("design", 5);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        topic.setRubrics(rubrics);
        assertEquals("implementation", rubrics.get(0).getCriteria());
        assertEquals(3, rubrics.get(0).getValue());
        assertEquals("testing", rubrics.get(1).getCriteria());
        assertEquals(2, rubrics.get(1).getValue());
        assertEquals("design", rubrics.get(2).getCriteria());
        assertEquals(5, rubrics.get(2).getValue());
    }
}