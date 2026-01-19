package ro.ase.ppoo.program;

import ro.ase.ppoo.enums.Gender;
import ro.ase.ppoo.models.Employee;
import ro.ase.ppoo.models.Manager;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

//În main: creați obiecte din clasa de la NOTA 6, salvați-le într-o colecție standard, sortați, afișați.
//Apelați metodea metoda abstractă pentru verificare.
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 28, Gender.MALE, 5000.0f, true, "IT");
        Employee employee1 = new Employee("Poppy Johnson", 30, Gender.FEMALE, 6000.0f, true, "HR");
        Employee employee2 = new Employee(employee1); // folosind constructorul de copiere
        Employee employee3 = new Employee("Mariah Carey", 49, Gender.FEMALE, 8000.0f, false, "Finance");
        Employee employee4 = new Employee("Lord Farquaad", 34, Gender.MALE, 7000.0f, true, "Management");

        List<Employee> employees1 = new ArrayList<>();
        employees1.add(employee);
        employees1.add(employee1);
        employees1.add(employee3);
        employees1.sort (Employee::compareTo);

        List<Employee> employees2= new ArrayList<>();
        employees2.add(employee2);
        employees2.add(employee4);
        employees1.sort (Employee::compareTo);


        Manager manager = new Manager("Oompa Loompa", 40, Gender.MALE, 3, "Chocolate Factory", employees1);
        Manager manager1 = new Manager("Gugu Gaga", 25, Gender.MALE, 4, "Baby Care", employees2);

        List <Manager> managers = new ArrayList<>();
        managers.add(manager);
        managers.add(manager1);
        managers.sort (Manager::compareTo);

        displayAll(managers);

        //Salvați datele din colecții în fișier text, un obiect pe linie.
        try {
            PrintStream ps = new PrintStream(new File("managers.txt"));
            for(Manager m: managers){
                ps.println(m);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void displayAll(List<Manager> l){
        if(!l.isEmpty()){
            for(Manager m: l){
                m.introduceYourself();
                System.out.println("Average salary on project: " + m.mediumSalaryOnProject());
                System.out.println("Salary after taxes for base 10000: " + m.calculateSalaryAfterTaxes(10000*m.getTeamSize()));
                System.out.println("My employees are: ");
                for(Employee e: m.getTeamMembers()){
                    System.out.println(e);
                }
                System.out.println("---------------------" );
            }
        }
    }

}