package Ex2;
public class BankAccountImpl implements BankAccount {
    private String bank;
    private double balance;
    BankAccountImpl(String bank, double initialDeposit){ 
        this.bank = bank;
        this.balance = initialDeposit; 
    }
    public String getBank() { 
        return this.bank ;
    }
    @Override public void deposit(double amount){
        this.balance += amount;
    }
    @Override public boolean withdraw(double amount){
        if (amount > this.balance) return false;
        this.balance -= amount;
        return true; 
    } 
    @Override public double balance(){
        return this.balance; 
    }
}