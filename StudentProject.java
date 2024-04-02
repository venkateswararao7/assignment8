import java.util.ArrayList;
import java.util.List;

class Project {
    private String studentName;
    private int daysToComplete;
    
    public Project(String studentName, int daysToComplete) {
        this.studentName = studentName;
        this.daysToComplete = daysToComplete;
    }
    
    public int getDaysToComplete() {
        return daysToComplete;
    }
}

class ProjectAnalyzer {
    private List<Project> projects;
    
    public ProjectAnalyzer(List<Project> projects) {
        this.projects = projects;
    }
    
    public void analyzeProjects() {
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        int totalDays = 0;
        
        for (Project project : projects) {
            int daysToComplete = project.getDaysToComplete();
            if (daysToComplete == 0) {
                onTimeCount++;
            } else if (daysToComplete < 0) {
                earlyCount++;
            } else {
                lateCount++;
            }
            totalDays += daysToComplete;
        }
        
        int totalProjects = projects.size();
        double averageDays = totalDays / (double) totalProjects;
        
        System.out.println("Projects completed on time: " + onTimeCount);
        System.out.println("Projects completed late: " + lateCount);
        System.out.println("Projects completed early: " + earlyCount);
        System.out.println("Average time taken per project: " + averageDays + " days");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Nani", -2));
        projects.add(new Project("Manoj", 3));
        projects.add(new Project("Kiran", 0));
        projects.add(new Project("Raghu", 2));
        
        ProjectAnalyzer analyzer = new ProjectAnalyzer(projects);
        analyzer.analyzeProjects();
    }
}
