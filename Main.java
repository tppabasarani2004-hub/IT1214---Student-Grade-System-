import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = input.nextDouble();

                    Student student = new Student(id, name, marks);
                    students.add(student);

                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\nStudent List:");
                        for (Student s : students) {
                            System.out.println("---------------------------");
                            System.out.println("ID    : " + s.getStudentId());
                            System.out.println("Name  : " + s.getStudentName());
                            System.out.println("Marks : " + s.getMarks());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = input.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.getStudentId() == searchId) {
                            System.out.println("Student Found");
                            System.out.println("ID    : " + s.getStudentId());
                            System.out.println("Name  : " + s.getStudentName());
                            System.out.println("Marks : " + s.getMarks());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        double total = 0;

                        for (Student s : students) {
                            total += s.getMarks();
                        }

                        double average = total / students.size();

                        System.out.println("Average Marks: " + average);
                    }
                    break;

                case 5:
                    System.out.println("Thank you.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}