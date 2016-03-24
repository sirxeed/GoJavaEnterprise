public class Semaphore implements Multithreading.Semaphore {
    private int permits;
    private final Object lock = new Object();

    public Semaphore(int permits) {
        this.permits = permits;
    }

    public void acquire() throws InterruptedException {
        if (permits > 0) {
            lock.notify();
        } else {
            lock.wait();
        }
    }
    java.util.concurrent.Semaphore sema = new java.util.concurrent.Semaphore(5);
    public void acquire(int permits) throws InterruptedException {
        if (this.permits >= permits) {
            for (int i = 0; i < permits; i++) {
                lock.notify();
            }
        } else {
            lock.wait();
        }
    }

    public void release() throws InterruptedException {
        while (permits < 1) {
            lock.wait();
        }
        permits++;
    }

    public void release(int permits) {
        this.permits += permits;
    }

    public int getAvailablePermits() {
        return permits;
    }
}
