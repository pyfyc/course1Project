public class Employee {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final int id;
    private int department;
    private double salary;
    private String sortId;
    private static int serial = 1;

    public Employee(String firstName, String secondName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = serial++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    private String getSortId() {
        return sortId;
    }

    public String getFIO() {
        return lastName + " " + firstName + " " + secondName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public static int compareTo(Employee a, Employee b) {
        if (a != null && b != null) {
            a.sortId = String.valueOf(a.department) + a.lastName;
            b.sortId = String.valueOf(b.department) + b.lastName;
            return a.sortId.compareTo(b.sortId);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " " + lastName + ", id: " + id + ", dep: " + department + ", salary: " + salary;
    }

}
