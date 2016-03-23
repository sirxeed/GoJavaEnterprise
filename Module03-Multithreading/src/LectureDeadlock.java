import java.util.Random;

public class LectureDeadlock {

    private static Random random = new Random();
    private static Account account1 = new Account(1, 100L);
    private static Account account2 = new Account(2, 200L);

    public static void main(String[] args) {
        new Thread(new Worker()).start();
        new Thread(new Worker()).start();
    }

    public static class Account implements Comparable<Account> {
        private long balance;
        private long id;

        public Account(long id, long balance) {
            this.id = id;
            this.balance = balance;
        }

        public long getBalance() {
            return balance;
        }

        public void put(long amount) {
            balance += amount;
        }

        public void withdraw(long amount) {
            balance -= amount;
        }

        @Override
        public int compareTo(Account o) {
            if (id > o.id) {
            return 1;
        } else if (id < o.id) {
                return -1;
            } else {
                return 0;
            }
            }
    }

    public static void transfer(Account source, Account target, long amount) {
        final Account a1 = source.compareTo(target) > 0 ? source : target;
        final Account a2 = source.compareTo(target) < 0 ? source : target;

        synchronized (a1) {
            synchronized (a2) {
                if (source.getBalance() >= amount) {
                    source.withdraw(amount);
                    target.put(amount);
                    System.out.println("Transfered " + amount);
                } else {
                    System.out.println("Not enough money!");
                }
            }
        }
    }

    public static class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (random.nextBoolean()) {
                    transfer(account1, account2, random.nextInt(10));
                } else {
                    transfer(account2, account1, random.nextInt(10));
                }

            }
        }
    }


}
