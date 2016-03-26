public class SemaphoreImplementation implements SemaphoreInterface {
    private volatile int permits;
    private volatile int threadsStarted;
    private int threadIndex = 1;
    private int counter = 0;

    private final Object lock = new Object();

    public SemaphoreImplementation(int permits) {
        this.permits = permits;
    }

    // ����������� ����������. ���� ���� ��������� ����������� ���. ���� ��� - ���������������� ����� �� ��� ��� ���� �� �������� ��������� ����������.
    @Override
    public void acquire() throws InterruptedException {
        synchronized (lock) {
            if (permits > 0) {
                //System.out.println("Thread \"" + Thread.currentThread().getName() + "\" acquired.");
                permits--;
                threadsStarted++;
            } else {
                //System.out.println("Thread \"" + Thread.currentThread().getName() + "\" freezed.");
                lock.wait();
            }
        }
    }

    // ����������� ��������� ���������� ����������. ���� ���� ��������� ���������� ��������� ���������� ����������� ��.
    // ���� ��� - ���������������� ����� �� ��� ��� ���� �� �������� ��������� ���������� ��������� ����������.
    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (lock) {
            if (this.permits >= permits) {
                //System.out.println("Thread \"" + Thread.currentThread().getName() + "\" acquired.");
                this.permits -= permits;
            } else {
                //System.out.println("Thread \"" + Thread.currentThread().getName() + "\" freezed.");
                lock.wait();
            }
        }
    }

    // ��������� ���������� ��������� ��� ��������.
    @Override
    public void release() throws InterruptedException {
        synchronized (lock) {
            if (threadsStarted > 0) {
                threadsStarted--;
                permits++;
                //System.out.println("Thread \"" + Thread.currentThread().getName() + "\" released.");
                lock.notify();
            }
        }
    }

    // ��������� ��������� ���������� ���������� ��������� �� ��������.
    @Override
    public void release(int permits) {
        synchronized (lock) {
            if (threadsStarted > permits) {
                threadsStarted -= permits;
                this.permits++;
                //System.out.println("Thread \"" + Thread.currentThread().getName() + "\" released.");
                lock.notify();
            }

        }
    }

    // ���������� ���������� ��������� ���������� �� ������ ������.
    @Override
    public int getAvailablePermits() {
        return permits;
    }

}
