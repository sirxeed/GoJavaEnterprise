import java.util.ArrayList;
import java.util.List;

public class Starter {
    private volatile static int counter = 0;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        final SemaphoreImplementation semaphore = new SemaphoreImplementation(1);
        for (int i = 1; i <= 1000; i++) {
            Thread thread = new Thread(new Worker(i, semaphore));
            thread.start();
        }

        Thread.sleep(100);

        for (Integer element : list) {
            System.out.println("Counter = " + element);
        }

    }

    public static class Worker implements Runnable {
        private int threadIndex;
        SemaphoreInterface semaphore;


        public Worker(int threadIndex, SemaphoreInterface semaphore) {
            this.threadIndex = threadIndex;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //System.out.println("Start of thread #" + threadIndex);

                //потік перевірив дозвіл семафору і якщо він є, то забрав його. Якщо ні - чекає.
                semaphore.acquire();

                list.add(++counter);
                //System.out.println("Counter = " + counter);
                //System.out.println("Critical section. Thread #" + threadIndex + ". Counter = " + counter);

                semaphore.release();
                //System.out.println("End of thread #" + threadIndex);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}