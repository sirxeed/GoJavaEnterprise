public class SemaphoreImplementation implements SemaphoreInterface {
    private volatile int permits;
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
                permits--;
            } else {
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
                this.permits -= permits;
            } else {
                lock.wait();
            }
        }
    }

    // ��������� ���������� ��������� ��� ��������.
    @Override
    public void release() throws InterruptedException {
        synchronized (lock) {
            permits++;
            lock.notify();
        }
    }

    // ��������� ��������� ���������� ���������� ��������� �� ��������.
    @Override
    public void release(int permits) {
        synchronized (lock) {
            this.permits++;
            lock.notify();

        }
    }

    // ���������� ���������� ��������� ���������� �� ������ ������.
    @Override
    public int getAvailablePermits() {
        return permits;
    }

}
