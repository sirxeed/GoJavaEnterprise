public class Starter {

    public static void main(String[] args) {
        SemaphoreInterfaceImplementation semaphore = new SemaphoreInterfaceImplementation(2);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Worker(i, semaphore));
            thread.start();
        }
    }
}
