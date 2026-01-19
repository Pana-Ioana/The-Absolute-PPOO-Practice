package ro.ase.ppoo.abstracts;

import ro.ase.ppoo.enums.Gender;

//Definiți o clasă abstractă de bază + cel puțin o metodă abstractă.
public abstract class Person implements Comparable<Person> {
    private String name;
    private int age;
    private Gender gender;

    // Constructor cu parametri
    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //Metode accesor


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    //toString()
    @Override
    public String toString() {
        return "Person { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    protected abstract void introduceYourself();

    //Comparable dupa varsta si nume
    @Override
    public int compareTo(Person other) {
        int ageComparison = Integer.compare(this.age, other.age);
        if(ageComparison!=0)
            return ageComparison;
        return this.name.compareTo(other.name);
    }
}
