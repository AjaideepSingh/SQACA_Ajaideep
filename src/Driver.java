import java.util.*;

public class Driver {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Rubric> rubrics = new ArrayList<>();
    private final ArrayList<Topic> topics = new ArrayList<>();

    public Driver() {
        String selection;
        System.out.println("Welcome to Student Grade Manager!");
        do {
            do {
                System.out.println("1.Create a student Grade Card");
                System.out.println("2.List of all rubrics");
                System.out.println("3.Get rubrics by topic name");
                System.out.println("4.Get student grades");
                System.out.println("5.View Summary of all student grades");
                System.out.println("6.Exit application");
                boolean flag;
                do {
                    System.out.print("Select menu option: ");
                    selection = scanner.next();
                    try {
                        Integer.parseInt(selection);
                        flag = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter only integer value");
                        flag = true;
                        break;
                    }
                } while (flag);
                if (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 6) {
                    System.out.println("Error occurred: Choose valid selection");
                } else if (Integer.parseInt(selection) == 1) {
                    createStudentGradeCard();
                } else if (Integer.parseInt(selection) == 2) {
                    if (rubrics.isEmpty()) {
                        System.out.println("Error no data available!");
                    } else {
                        listAllRubrics();
                    }
                } else if (Integer.parseInt(selection) == 3) {
                    if (topics.isEmpty()) {
                        System.out.println("Error no data available!");
                    } else {
                        System.out.print("Enter topic name: ");
                        String name = scanner.next();
                        boolean found = false;
                        for (Topic topic : topics) {
                            found = topic.getTopicName().equalsIgnoreCase(name);
                            if (found = true) {
                                getRubricByTopicName(name);
                                break;
                            } else if (found = false) {
                                System.out.println("Error occurred: topic doesn't exist");
                            }
                        }
                    }
                } else if (Integer.parseInt(selection) == 4) {
                    if (students.isEmpty()) {
                        System.out.println("Error no data available!");
                    } else {
                        System.out.print("Enter student first name: ");
                        String name = scanner.next();
                        boolean found = false;
                        for (Student student : students) {
                            found = student.getFirstName().equalsIgnoreCase(name);
                            if (found = true) {
                                getSpecificStudentGrade(name);
                                break;
                            } else if (found = false) {
                                System.out.println("Error occurred: student doesn't exist");
                            }
                        }
                    }
                } else if (Integer.parseInt(selection) == 5) {
                    if (students.isEmpty()) {
                        System.out.println("Error no data available!");
                    } else {
                        calculations();
                    }
                } else if (Integer.parseInt(selection) == 6) {
                    System.out.println("Goodbye!");
                }
            } while (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 6);
        } while (Integer.parseInt(selection) != 6);
    }

    public void createStudentGradeCard() {
        int criteriaAmount;
        ArrayList<Rubric> rubrics2 = new ArrayList<>();
        rubrics2.clear();
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter topic name: ");
        String topicName = scanner.next();
        do {
            System.out.print("How many criteria would you like for this rubric: ");
            criteriaAmount = scanner.nextInt();
            if (criteriaAmount < 1 || criteriaAmount > 10) {
                System.out.println("Error occurred: choose 1-10 criteria");
            }
        } while (criteriaAmount < 1 || criteriaAmount > 10);
        for (int e = 0; e < criteriaAmount; e++) {
            System.out.print("Enter criteria name: ");
            String criteriaName = scanner.next();
            int criteriaValue;
            do {
                System.out.print("Enter criteria value: ");
                criteriaValue = scanner.nextInt();
                if (criteriaValue < 1 || criteriaValue > 5) {
                    System.out.println("Error occurred: choose 1-5");
                }
            } while (criteriaValue < 1 || criteriaValue > 5);
            Rubric rubric = new Rubric(criteriaName, criteriaValue);
            rubrics2.add(rubric);
            rubrics.add(rubric);
        }
        Topic topic = new Topic(topicName, rubrics2);
        topics.add(topic);
        Student student = new Student(firstName, lastName, topic);
        students.add(student);
        System.out.println("Student grade card created successfully!");
    }

    public void listAllRubrics() {
        for (Rubric rubric : rubrics) {
            System.out.println("Rubric name: " + rubric.getCriteria());
        }
    }

    public void getRubricByTopicName(String name) {
        ArrayList<Rubric> rubricArrayList = new ArrayList<>();
        for (Topic topic : topics) {
            if (topic.getTopicName().equalsIgnoreCase(name)) {
                System.out.println("Topic name: " + topic.getTopicName());
                rubricArrayList = topic.getRubrics();
                break;
            }
        }
        for (Rubric rubric : rubricArrayList) {
            System.out.println("Rubric name: " + rubric.getCriteria());
        }
    }

    public void getSpecificStudentGrade(String name) {
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Topic: " + student.getTopic().getTopicName());
                for (int e = 0; e < student.getTopic().getRubrics().size(); e++) {
                    System.out.println("Rubric name: " + student.getTopic().getRubrics().get(e).getCriteria());
                    System.out.println("Rubric value: " + student.getTopic().getRubrics().get(e).getValue());
                }
            }
        }
    }

    public void calculations() {
        for (Student student : students) {
            System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
            calculateAverage(student.getTopic().getRubrics());
            calculateMinimumRubricScore(student.getTopic().getRubrics());
            calculateMaximumRubricScore(student.getTopic().getRubrics());
            calculateStandardDeviation(student.getTopic().getRubrics());
        }
        System.out.println("Calculations based on all students!");
        calculateTotalAverage(rubrics);
        calculateTotalMin(rubrics);
        calculateTotalMax(rubrics);
        calculateTotalSD(rubrics);
    }

    public int calculateAverage(ArrayList<Rubric> rubrics) {
        int totalGrade = 0;
        for (Rubric rubric : rubrics) {
            totalGrade += rubric.getValue();
        }
        System.out.println("Average rubric mark: " + totalGrade / rubrics.size());
        return totalGrade / rubrics.size();
    }

    public int calculateMinimumRubricScore(ArrayList<Rubric> rubrics) {
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric rubric : rubrics) {
            results.add(rubric.getValue());
        }
        System.out.println("Lowest rubric result: " + Collections.min(results));
        return Collections.min(results);
    }

    public int calculateMaximumRubricScore(ArrayList<Rubric> rubrics) {
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric rubric : rubrics) {
            results.add(rubric.getValue());
        }
        System.out.println("Highest rubric result: " + Collections.max(results));
        return Collections.max(results);
    }

    public double calculateStandardDeviation(ArrayList<Rubric> rubrics) {
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric rubric : rubrics) {
            results.add(rubric.getValue());
        }
        double standardDeviation = 0.0;
        int sum = results.stream().mapToInt(Integer::intValue).sum();
        double mean = sum / results.size();
        for (double num : results) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        System.out.println("Standard deviation: " + standardDeviation / results.size());
        return Math.sqrt(standardDeviation / results.size());
    }

    public int calculateTotalAverage(ArrayList<Rubric> rubrics) {
        int totalGrade = 0;
        for (Rubric rubric : rubrics) {
            totalGrade += rubric.getValue();
        }
        System.out.println("Total average rubric mark: " + totalGrade / rubrics.size());
        return totalGrade / rubrics.size();
    }

    public int calculateTotalMin(ArrayList<Rubric> rubrics) {
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric rubric : rubrics) {
            results.add(rubric.getValue());
        }
        System.out.println("Total lowest rubric result: " + Collections.min(results));
        return Collections.min(results);
    }

    public int calculateTotalMax(ArrayList<Rubric> rubrics) {
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric rubric : rubrics) {
            results.add(rubric.getValue());
        }
        System.out.println("Total highest rubric result: " + Collections.max(results));
        return Collections.max(results);
    }

    public double calculateTotalSD(ArrayList<Rubric> rubrics) {
        ArrayList<Integer> results = new ArrayList<>();
        for (Rubric rubric : rubrics) {
            results.add(rubric.getValue());
        }
        double standardDeviation = 0.0;
        int sum = results.stream().mapToInt(Integer::intValue).sum();
        double mean = sum / results.size();
        for (double num : results) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        System.out.println("Total standard deviation: " + standardDeviation / results.size());
        return Math.sqrt(standardDeviation / results.size());
    }

    public static void main(String[] args) {
        new Driver();
    }
}
