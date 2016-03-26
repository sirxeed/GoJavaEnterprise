public class Starter {
    private static int counter = 0;

    public static void main(String[] args) {
        final SemaphoreImplementation semaphore = new SemaphoreImplementation(1);
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new Worker(i, semaphore));
            thread.start();
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

                //початок критичної секції
                counter++;
                System.out.println("Counter = " + counter);
                //System.out.println("Critical section. Thread #" + threadIndex + ". Counter = " + counter);
                semaphore.release();//критична секція закінчилась - віддаємо дозвіл.

                //System.out.println("End of thread #" + threadIndex);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}