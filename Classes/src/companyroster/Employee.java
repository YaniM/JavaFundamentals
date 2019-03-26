package companyroster;

public class Employee {
    private static final String EMAIL_DEFAULT = "n/a";
    private static final int AGE_DEFAULT = -1;

    private String name;
    private double salary;
    private String email;
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.email = Employee.EMAIL_DEFAULT;
        this.age = Employee.AGE_DEFAULT;
    }

    public Employee(String name, double salary, int age) {
        this(name, salary);
        this.age = age;
    }

    public Employee(String name, double salary, String email) {
        this(name, salary);
        this.email = email;
    }

    public Employee(String name, double salary, String email, int age) {
        this(name, salary);
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
