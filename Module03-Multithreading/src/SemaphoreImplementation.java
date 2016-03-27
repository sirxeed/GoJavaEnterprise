public class SemaphoreImplementation implements SemaphoreInterface {
    private volatile int permits;

    private final Object lock = new Object();

    public SemaphoreImplementation(int permits) {
        this.permits = permits;
    }

    // Запрашивает разрешение. Если есть свободное захватывает его. Если нет - приостанавливает поток до тех пор пока не появится свободное разрешение.
    @Override
    public synchronized void acquire() throws InterruptedException {
        synchronized (lock) {
            if (permits > 0) {
                permits--;
            } else {
                lock.wait();
            }
        }
    }

    // Запрашивает переданое количество разрешений. Если есть переданое количество свободных разрешений захватывает их.
    // Если нет - приостанавливает поток до тех пор пока не появится переданое колтчество свободных разрешений.
    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (lock) {
            if (this.permits >= permits) {
                this.permits -= permits;
            } else {
                lock.wait();
            }
        }
    }

    // Отпускает разрешение возвращая его семафору.
    @Override
    public synchronized void release() throws InterruptedException {
        synchronized (lock) {
            lock.wait(5);
            permits++;
            System.out.println(permits);
            lock.notify();
        }
    }

    // Отпускает переданое количество разрешений возварщая их семафору.
    @Override
    public void release(int permits) throws InterruptedException {
        synchronized (lock) {
            this.permits += permits;
            for (int i = 0; i < permits; i++) {
                lock.notify();
                lock.wait(5);
            }
        }
    }

    // Возвращает количество свободных разрешений на данный момент.
    @Override
    public int getAvailablePermits() {
        return permits;
    }
}