import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook();

        book.addEmployee("Daniil","Sergeyevich","Medvedev",2,60_000);
        book.addEmployee("William", "Henry", "Gates", 1, 10_000);
        book.addEmployee("Melinda", "French", "Gates", 1, 8_000);
        book.addEmployee("Jeffrey", "Preston", "Bezos", 1, 12_000);
        book.addEmployee("Rafael","Nadal", "Parera", 2,50_000);
        book.addEmployee("Novak","","Djokovic",2,45_000);

        book.printEmployees(book.ALL_DEPARTMENTS);

        //book.deleteEmployee(3);
        //book.addEmployee("William", "Henry", "Gates", 1, 10_000);
        //book.changeSalary("Djokovic","Novak","", 1_000_000);
        //book.changeDepartment("Djokovic", "Novak","",5);

        //System.out.println("Total salary expenses: " + calcTotalSalary(1));
        //System.out.println("Lowest paid employee: " + getLowestPaidEmployee(2));
        //System.out.println("Highest paid employee: " + getHighestPaidEmployee(ALL_DEPARTMENTS));
        //System.out.println("Average salary: " + calcAverageSalary(ALL_DEPARTMENTS));
        //printEmployeesFIO(1);

        //indexSalaryByRate(-50, 9);
        //System.out.println("-----");
        //book.printEmployeesByDeps();
        //System.out.println("-----");
        //book.printEmployees(book.ALL_DEPARTMENTS);
        //printEmployeesPaidLessThan(50000);
        //System.out.println("-----");
        //printEmployeesPaidMoreEqualThan(50000);
    }
}