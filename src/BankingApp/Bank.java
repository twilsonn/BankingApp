package BankingApp;

public class Bank {
    int balance;

    Bank() {
        this.balance = 0;
    }

    Bank(int balance) {
        this.balance = balance;
    }

    void deposit(int amount) {
        this.balance += amount;
    }

    int withdraw (int amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
            return this.balance;
        } else {
            return -1;
        }
    }

    int checkBalance() {
        return this.balance;
    }
}
