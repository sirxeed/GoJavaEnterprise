public class SemaphoreImplementation implements SemaphoreInterface {
    private volatile int permits;

    private final Object lock = new Object();

    public SemaphoreImplementation(int permits) {
        this.permits = permits;
    }

    // ����������� ����������. ���� ���� ��������� ����������� ���. ���� ��� - ���������������� ����� �� ��� ��� ���� �� �������� ��������� ����������.
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
    public synchronized void release() throws InterruptedException {
        synchronized (lock) {
            lock.wait(5);
            permits++;
            System.out.println(permits);
            lock.notify();
        }
    }

    // ��������� ��������� ���������� ���������� ��������� �� ��������.
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

    // ���������� ���������� ��������� ���������� �� ������ ������.
    @Override
    public int getAvailablePermits() {
        return permits;
    }
}