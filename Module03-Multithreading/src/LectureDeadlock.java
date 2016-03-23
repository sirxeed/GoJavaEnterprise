public class LectureDeadlock {
    public static class Account {
        private long balance;

        public Account(long balance) {
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

        public static void transfer(Account source, Account target, long amount){
            if (source.getBalance() >= amount) {
                source.withdraw(amount);
                target.put(amount);
            }
        }
    }
}
