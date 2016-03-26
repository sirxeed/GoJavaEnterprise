public class SemaphoreImplementation implements SemaphoreInterface {
    private volatile int permits;

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
            this.permits += permits;
            for (int i = 0; i < permits; i++) {
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