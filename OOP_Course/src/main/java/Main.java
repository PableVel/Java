import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
       /* Employee e1 = new Employee("Pablo",24,25_000, TypeLocation.Guadalajara);
        Employee e2 = new Employee("Jose",45,60_000, TypeLocation.Guadalajara);

        e1.raiseSalary(5000);
        e1.showSalary();
        e2.showSalary();*/

        /*BankAccount account = new BankAccount("Pablo",10000);
        account.withdraw(100);
        System.out.println("Current balance: "+account.getBalance());
    /*/

        ModArrayList arrayList = new ModArrayList();

        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

        System.out.println(arrayList.getUsingMod(1));
        System.out.println(arrayList.getUsingMod(-1));
        System.out.println(arrayList.getUsingMod(40));

    }
}
