public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner(){
        return owner;
    }

    public void withdraw(double money){
        balance = balance - money;
        System.out.println("Balance: "+balance);
        System.out.println("Withdrawn money: "+money);
    }

    public void deposited(double money){
        balance =+ money;
        System.out.println("Balance: "+balance);
        System.out.println("Deposited money: "+money);
    }
}
