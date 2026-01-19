package ro.ase.ppoo.models;

import ro.ase.ppoo.abstracts.Person;
import ro.ase.ppoo.enums.Gender;
import ro.ase.ppoo.interfaces.Payable;

import java.util.ArrayList;
import java.util.List;

//Definiți o clasă non-abstractă derivată dintr-o abstractă care implementează interfata
//Această clasă conține o colecție / vector cu obiecte cealalta clasa concreta.
//Implementați metoda abstractă + metoda din interfață.
public class Manager extends Person implements Payable {
    private int teamSize;
    private String project;

    private List<Employee> teamMembers = new ArrayList<>();

    public Manager(String name, int age, Gender gender, int teamSize, String project, List<Employee> teamMembers) {
        super(name, age, gender);
        this.teamSize = teamSize;
        this.project = project;
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "Manager { " +
                "teamSize=" + teamSize +
                ", project='" + project + '\'' +
                ", teamMembers=" + teamMembers +
                "} " + super.toString();
    }

    @Override
    protected void introduceYourself() {
        System.out.println("Hello, my name is " + getName() + ", I manage the project " + project + ".");
    }

    @Override
    public float calculateSalaryAfterTaxes(float baseSalary) {
        return baseSalary * 0.75f; // Exemplu simplu: 25% taxe
    }

    //Implementați o metodă care face o operație pe elementele colecției
    public float mediumSalaryOnProject(){
        float salary =0;
        for(Employee e: teamMembers){
            salary+=e.getSalary();
        }
        return salary/teamMembers.size();
    }

    //sau mai simplu adaugam membri in echipa
    public void addTeamMember(Employee e){
        if(teamMembers.size()<teamSize && !teamMembers.contains(e))
            teamMembers.add(e);
    }
}
