public class Rubric {
    private String criteria;
    private int value;

    public Rubric() {
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Rubric(String criteria, int value) {
        this.criteria = criteria;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rubric: " +
                "criteria: " + criteria + ", value: " + value;
    }
}