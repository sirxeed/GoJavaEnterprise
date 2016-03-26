public class SemaphoreImplementation implements SemaphoreInterface {
    private volatile int permits;
    private int threadIndex = 1;
    private int counter = 0;

    private final Object lock = new Object();

    public SemaphoreImplementation(int permits) {
        this.permits = permits;
    }

    // Запрашивает разрешение. Если есть свободное захватывает его. Если нет - приостанавливает поток до тех пор пока не появится свободное разрешение.
    @Override
    public void acquire() throws InterruptedException {
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
    public void release() throws InterruptedException {
        synchronized (lock) {
            permits++;
            lock.notify();
        }
    }

    // Отпускает переданое количество разрешений возварщая их семафору.
    @Override
    public void release(int permits) {
        synchronized (lock) {
            this.permits++;
            lock.notify();

        }
    }

    // Возвращает количество свободных разрешений на данный момент.
    @Override
    public int getAvailablePermits() {
        return permits;
    }

}
