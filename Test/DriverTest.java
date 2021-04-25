
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DriverTest {
    private final Driver driver = new Driver();

    @Test
    void calculateAverage() {
        ArrayList<Rubric> rubrics = new ArrayList<>();
        Rubric rubric = new Rubric("Design", 10);
        Rubric rubric1 = new Rubric("Implementation", 2);
        rubrics.add(rubric);
        rubrics.add(rubric1);
        assertEquals(6, driver.calculateAverage(rubrics));
    }

    @Test
    void calculateMinimumRubricScore() {
        Rubric rubric = new Rubric("Impl", 1);
        Rubric rubric1 = new Rubric("Design", 2);
        Rubric rubric2 = new Rubric("Testing", 3);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        assertEquals(1, driver.calculateMinimumRubricScore(rubrics));
    }

    @Test
    void calculateMaximumRubricScore() {
        Rubric rubric = new Rubric("Impl", 1);
        Rubric rubric1 = new Rubric("Design", 2);
        Rubric rubric2 = new Rubric("Testing", 3);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        assertEquals(3, driver.calculateMaximumRubricScore(rubrics));
    }

    @Test
    void calculateStandardDeviation() {
        Rubric rubric = new Rubric("Impl", 1);
        Rubric rubric1 = new Rubric("Design", 2);
        Rubric rubric2 = new Rubric("Testing", 3);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric r : rubrics) {
            results.add(r.getValue());
        }
        double standardDeviation = 0.0;
        int sum = results.stream().mapToInt(Integer::intValue).sum();
        double mean = sum / results.size();
        for (double num : results) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        assertEquals(Math.sqrt(standardDeviation / results.size()), driver.calculateStandardDeviation(rubrics));
        assertEquals(Math.sqrt(standardDeviation / results.size()), driver.calculateTotalSD(rubrics));
    }

    @Test
    void calculateTotalMin() {
        Rubric rubric = new Rubric("Impl", 1);
        Rubric rubric1 = new Rubric("Design", 2);
        Rubric rubric2 = new Rubric("Testing", 3);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric r : rubrics) {
            results.add(r.getValue());
        }
        assertEquals(1, driver.calculateTotalMin(rubrics));
    }

    @Test
    void calculateTotalMax() {
        Rubric rubric = new Rubric("Impl", 1);
        Rubric rubric1 = new Rubric("Design", 2);
        Rubric rubric2 = new Rubric("Testing", 3);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric r : rubrics) {
            results.add(r.getValue());
        }
        assertEquals(3, driver.calculateTotalMax(rubrics));
    }

    @Test
    void calculateTotalAverage() {
        ArrayList<Rubric> rubrics = new ArrayList<>();
        Rubric rubric = new Rubric("Design", 10);
        Rubric rubric1 = new Rubric("Implementation", 2);
        rubrics.add(rubric);
        rubrics.add(rubric1);
        assertEquals(6, driver.calculateTotalAverage(rubrics));
    }

    @Test
    void calculateTotalStandardDeviation() {
        Rubric rubric = new Rubric("Impl", 1);
        Rubric rubric1 = new Rubric("Design", 2);
        Rubric rubric2 = new Rubric("Testing", 3);
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric1);
        rubrics.add(rubric2);
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric r : rubrics) {
            results.add(r.getValue());
        }
        double standardDeviation = 0.0;
        int sum = results.stream().mapToInt(Integer::intValue).sum();
        double mean = sum / results.size();
        for (double num : results) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        assertEquals(Math.sqrt(standardDeviation / results.size()), driver.calculateTotalSD(rubrics));
    }
}