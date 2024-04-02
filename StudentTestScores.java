import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

class ScoreAnalyzer {
    private List<Student> students;

    public ScoreAnalyzer(List<Student> students) {
        this.students = students;
    }

    public void analyzeScores() {
        int totalScore = 0;
        for (Student student : students) {
            totalScore += student.getScore();
        }
        double averageScore = totalScore / (double) students.size();

        List<Integer> scores = new ArrayList<>();
        for (Student student : students) {
            scores.add(student.getScore());
        }
        Collections.sort(scores);

        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;

        double medianScore;
        int size = students.size();
        if (size % 2 == 0) {
            medianScore = (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2.0;
        } else {
            medianScore = scores.get(size / 2);
        }

        for (Integer score : scores) {
            if (score > averageScore) {
                aboveAverageCount++;
            } else if (score < averageScore) {
                belowAverageCount++;
            } else {
                atAverageCount++;
            }
        }

        System.out.println("Number of students above average: " + aboveAverageCount + ", Median score: " + medianScore);
        System.out.println("Number of students at average: " + atAverageCount + ", Median score: " + medianScore);
        System.out.println("Number of students below average: " + belowAverageCount + ", Median score: " + medianScore);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nani", 95));
        students.add(new Student("Kishu", 67));
        students.add(new Student("Mani", 82));
        students.add(new Student("LiKhi", 55));
        students.add(new Student("nitin", 73));

        ScoreAnalyzer analyzer = new ScoreAnalyzer(students);
        analyzer.analyzeScores();
    }
}
