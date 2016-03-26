public class Starter {

    public static void main(String[] args) {
        SemaphoreImplementation semaphore = new SemaphoreImplementation(2);
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new Worker(i, semaphore));
            thread.start();
        }
    }
}
