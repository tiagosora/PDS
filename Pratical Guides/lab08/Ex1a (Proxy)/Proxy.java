package Ex1a;
public class Proxy implements BankAccount   {
    private BankAccountImpl bank;
    public Proxy(String bank, double initialDeposit) {
        this.bank = new BankAccountImpl(bank, initialDeposit);
    }
    @Override
    public void deposit(double amount) {
        this.bank.deposit(amount);        
    }
    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return this.bank.withdraw(amount);
        }
        System.out.println("Operation Withdraw : Access Denied");
        return false;
    }
    @Override
    public double balance() {
        if (Company.user == User.OWNER) {
            return this.bank.balance();
        }
        System.out.println("Operation Balance : Access Denied");
        return -1;
    }
}