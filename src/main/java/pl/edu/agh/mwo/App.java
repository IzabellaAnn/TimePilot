package pl.edu.agh.mwo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Model model = new Model();

        System.out.println("Welcome to the Time Pilot!");

        // Prompt for one project name
        System.out.print("Enter the project name: ");
        String projectName = scanner.nextLine();
        Project project = new Project(projectName);
        model.addProject(project);
        System.out.println("Project '" + projectName + "' created.");

        // Prompt for one task name
        System.out.print("Enter a task: ");
        String taskName = scanner.nextLine();
        project.addTask(taskName);
        System.out.println("Task '" + taskName + "' added to project '" + projectName + "'.");

        // Show the project and its tasks
        System.out.println("\nProject Overview:");
        project.showProject();

        System.out.println("Thank you for using our Time Pilot!");

        scanner.close();
    }
}

