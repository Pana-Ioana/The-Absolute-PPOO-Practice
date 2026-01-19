package ro.ase.ppoo.program;

import ro.ase.ppoo.models.Manager;

//Metodă de „prelucrare” pe un obiect
//Thread derivat din Thread: de max 10 ori încearcă prelucrarea cu valori random; dacă nu reușește → excepție.
//Lansați 2 thread-uri în main.
public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try{
                System.out.println("Thread: " + Thread.currentThread().getName() + " - Attempt " + (i+1));
                Thread.sleep(500);
            }
            catch (Exception e){
                System.out.println("Thread: " + Thread.currentThread().getName() + " - Exception occurred: " + e.getMessage());
            }

            for(Manager m : Main.managersList){
                try{
                    if(Main.managersList.isEmpty()){
                        throw new MyException("No managers available for processing.");
                    }
                }
                catch (MyException e){
                    System.out.println("Thread: " + Thread.currentThread().getName() + " - " + e.getMessage());
                }

                m.calculateSalaryAfterTaxes((float)Math.random() * 10000);
                System.out.println("Thread: " + Thread.currentThread().getName() + " - Processed manager: " + m.getName());
            }
        }
    }
}
