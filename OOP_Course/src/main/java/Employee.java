import java.sql.SQLOutput;

public class Employee {
    String name;
    int age;
    int salary;
    TypeLocation location;
    static String empresa = "EPAM";

    public Employee(String name, int age, int salary, TypeLocation location) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }

    void raiseSalary(int salaryIncrease){
        this.salary = salaryIncrease;
    }

    static void whereWork(){
        System.out.println(empresa+"! the best place to work");
    }

    void showSalary(){
        System.out.println("Salary of "+name+ ": "+salary);
    }
}
