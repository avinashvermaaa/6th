// Experiment 1.1 Java


import java.util.Scanner;

public class EmployeeDetailsApp {
    public static void main(String[] args) {
        // Create an array to store employee data
        Employee[] employees = new Employee[8]; // Adjust the size based on the number of employees

        // Add employee data to the array
        employees[0] = new Employee(1001, "Ashish", "R&D", "e", 20000, 8000, 3000);
        employees[1] = new Employee(1002, "Suman", "PM", "m", 30000, 12000, 9000);
        employees[2] = new Employee(1003, "Rahul", "Acct", "k", 10000, 8000, 1000);

        // Accept employee id from the command prompt
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int empIdToSearch = scanner.nextInt();

        // Find and display employee details
        boolean found = false;
        for (Employee employee : employees) {
            if (employee != null && employee.getEmpNo() == empIdToSearch) {
                System.out.println("Employee Details:");
                System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");

                // Using switch-case to print Designation and calculate total salary
                switch (employee.getDesigCode()) {
                    case "e":
                        System.out.println(employee.getEmpNo() + "\t" + employee.getEmpName() + "\t" +
                                employee.getDept() + "\t\tEngineer\t" + employee.calculateSalary(20000));
                        break;
                    case "c":
                        // Add more cases for other designations
                        System.out.println(employee.getEmpNo() + "\t" + employee.getEmpName() + "\t" +
                                employee.getDept() + "\t\tConsultant\t" + employee.calculateSalary(32000));
                        break;
                    case "k":
                        System.out.println(employee.getEmpNo() + "\t" + employee.getEmpName() + "\t" +
                                employee.getDept() + "\t\tClerk\t\t" + employee.calculateSalary(12000));
                        break;
                    case "r":
                        System.out.println(employee.getEmpNo() + "\t" + employee.getEmpName() + "\t" +
                                employee.getDept() + "\t\tReceptionist\t" + employee.calculateSalary(15000));
                        break;
                    case "m":
                        System.out.println(employee.getEmpNo() + "\t" + employee.getEmpName() + "\t" +
                                employee.getDept() + "\t\tManager\t\t" + employee.calculateSalary(40000));
                        break;
                    default:
                        System.out.println("Invalid Designation Code");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid: " + empIdToSearch);
        }

        // Close the scanner
        scanner.close();
    }
}

class Employee {
    private int EmpNo;
    private String empName;
    private String Dept;
    private String DesigCode;
    private int basic;
    private int hra;
    private int it;

    // Constructor
    public Employee(int EmpNo, String empName, String Dept, String DesigCode, int basic, int hra, int it) {
        this.EmpNo = EmpNo;
        this.empName = empName;
        this.Dept = Dept;
        this.DesigCode = DesigCode;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    // Getters
    public int getEmpNo() {
        return EmpNo;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDept() {
        return Dept;
    }

    public String getDesigCode() {
        return DesigCode;
    }

    public int getBasic() {
        return basic;
    }

    public int getHra() {
        return hra;
    }

    public int getIt() {
        return it;
    }

    // Method to calculate total salary
    public int calculateSalary(int da) {
        return basic + hra + da - it;
    }
}
