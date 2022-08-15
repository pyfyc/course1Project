import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    public final int ALL_DEPARTMENTS = -1;
    private final String ERR_DEP_NOT_FOUND = "Department not found";
    private final String ERR_EMPL_NOT_FOUND = "Employee not found";

    public void printEmployees(int department) {
        if (!isValidDepartment(department)) {
            throw new RuntimeException(ERR_DEP_NOT_FOUND);
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (department == ALL_DEPARTMENTS) {
                    System.out.println(employees[i]);
                } else if (department > 0 && employees[i].getDepartment() == department) {
                    System.out.println(employees[i]);
                }
            }
        }
    }

    // If department = ALL_DEPARTMENTS -> calculate total for all employees.
    // If department > 0  -> calculate total for that department only.
    private double calcTotalSalary(int department) {
        if (!isValidDepartment(department)) {
            throw new RuntimeException(ERR_DEP_NOT_FOUND);
        }
        double total = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (department == ALL_DEPARTMENTS) {
                    total += employees[i].getSalary(); // for all employees
                } else if (department > 0 && employees[i].getDepartment() == department) {
                    total += employees[i].getSalary(); // only for one department
                }
            }
        }
        return total;
    }

    private Employee getDefaultEmployee(int department) {
        // Default value for all employees
        Employee employee = employees[0];
        // Reinitialize default value for department
        if (department > 0) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getDepartment() == department) {
                    employee = employees[i];
                    break;
                }
            }
        }
        return employee;
    }

    private Boolean isValidDepartment(int department) {
        if (department == ALL_DEPARTMENTS) {
            return true;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                return true;
            }
        }
        return false;
    }

    private Employee getLowestPaidEmployee(int department) {
        if (!isValidDepartment(department)) {
            throw new RuntimeException(ERR_DEP_NOT_FOUND);
        }
        Employee employee = getDefaultEmployee(department);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee) == false) {
                if (department == ALL_DEPARTMENTS && employees[i].getSalary() < employee.getSalary()) {
                    employee = employees[i];
                } else if (department > 0 && employees[i].getDepartment() == department && employees[i].getSalary() < employee.getSalary()) {
                    employee = employees[i];
                }
            }
        }
        return employee;
    }

    private Employee getHighestPaidEmployee(int department) {
        if (!isValidDepartment(department)) {
            throw new RuntimeException(ERR_DEP_NOT_FOUND);
        }
        Employee employee = getDefaultEmployee(department);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee) == false) {
                if (department == ALL_DEPARTMENTS && employees[i].getSalary() > employee.getSalary()) {
                    employee = employees[i];
                } else if (department > 0 && employees[i].getDepartment() == department && employees[i].getSalary() > employee.getSalary()) {
                    employee = employees[i];
                }
            }
        }
        return employee;
    }

    private int countEmployees(int department) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (department == ALL_DEPARTMENTS) {
                    count++;
                } else if (department > 0 && employees[i].getDepartment() == department) {
                    count++;
                }
            }
        }
        return count;
    }

    private double calcAverageSalary(int department) {
        return calcTotalSalary(department) / countEmployees(department);
    }

    private void printEmployeesFIO(int department) {
        if (!isValidDepartment(department)) {
            throw new RuntimeException(ERR_DEP_NOT_FOUND);
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (department == ALL_DEPARTMENTS) {
                    System.out.println(employees[i].getFIO());
                } else if (department > 0 && employees[i].getDepartment() == department) {
                    System.out.println(employees[i].getFIO());
                }
            }
        }
    }

    private void indexSalaryByRate(double indexRate, int department) {
        if (!isValidDepartment(department)) {
            throw new RuntimeException(ERR_DEP_NOT_FOUND);
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (department == ALL_DEPARTMENTS) {
                    employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() / 100 * indexRate);
                } else if (department > 0 && employees[i].getDepartment() == department) {
                    employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() / 100 * indexRate);
                }
            }
        }
    }

    private void printEmployeesPaidLessThan(double maxLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < maxLimit) {
                System.out.println("id: " + employees[i].getId() + ", " +
                        "FIO: " + employees[i].getFirstName() + " " + employees[i].getSecondName() + " " + employees[i].getLastName() + ", " +
                        "salary: " + employees[i].getSalary());
            }
        }
    }

    private void printEmployeesPaidMoreEqualThan(double minLimit) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= minLimit) {
                System.out.println("id: " + employees[i].getId() + ", " +
                        "FIO: " + employees[i].getFirstName() + " " + employees[i].getSecondName() + " " + employees[i].getLastName() + ", " +
                        "salary: " + employees[i].getSalary());
            }
        }
    }

    private Employee getEmployeeByFIO(String lastName, String firstName, String secondName) {
        Employee employee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getLastName() == lastName && employees[i].getFirstName() == firstName && employees[i].getSecondName() == secondName) {
                    employee = employees[i];
                }
            }
        }
        return employee;
    }

    public void addEmployee(String firstName, String secondName, String lastName, int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee employee = new Employee(firstName, secondName, lastName, department, salary);
                employees[i] = employee;
                return;
            }
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void changeSalary(String lastName, String firstName, String secondName, double newSalary) {
        Employee employee = getEmployeeByFIO(lastName, firstName, secondName);
        if (employee != null) {
            employee.setSalary(newSalary);
        } else {
            throw new RuntimeException(ERR_EMPL_NOT_FOUND);
        }
    }

    public void changeDepartment(String lastName, String firstName, String secondName, int newDepartment) {
        Employee employee = getEmployeeByFIO(lastName, firstName, secondName);
        if (employee != null) {
            employee.setDepartment(newDepartment);
        } else {
            throw new RuntimeException(ERR_EMPL_NOT_FOUND);
        }
    }

    public void printEmployeesByDeps() {
        int dep = -1;
        Arrays.sort(employees, Employee::compareTo);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() != dep) {
                    dep = employees[i].getDepartment();
                    System.out.println("Department " + dep + ":");
                }
                System.out.println(employees[i].getFIO());
            }
        }
    }
}
