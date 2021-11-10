import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
    Scanner input = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private double salary;

    public void addDetails() {
        System.out.println("You are adding a new employee.");
        System.out.println("First name:");
        setFirstName(input.nextLine());
        System.out.println("Last name:");
        setLastName(input.nextLine());
        System.out.println("Salary: ");
        for (int i = 0; i < 1; i++) {
            try {
                setSalary(input.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("You've entered a string, please enter an integer value");
                i--;
                input.nextLine();
            }
        }
        input.nextLine();
        System.out.println("You have successfully added an employee\n");
    }


    public void getAllData() {
        System.out.println("Salary for " + firstName + " " + lastName + " is " + salary);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
