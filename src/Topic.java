import java.util.ArrayList;

public class Topic {
    private String topicName;
    private ArrayList<Rubric> rubrics;

    public Topic() {
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public ArrayList<Rubric> getRubrics() {
        return rubrics;
    }

    public void setRubrics(ArrayList<Rubric> rubrics) {
        this.rubrics = rubrics;
    }

    public Topic(String topicName, ArrayList<Rubric> rubrics) {
        this.topicName = topicName;
        this.rubrics = rubrics;
    }

    @Override
    public String toString() {
        return "Topic: " +
                "topicName: " + topicName + '\'' +
                ", rubrics: " + rubrics;
    }
}