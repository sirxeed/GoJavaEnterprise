public class Worker implements Runnable {
    private int threadIndex;
    SemaphoreInterface semaphore;
    private volatile int counter = 0;

    public Worker (int threadIndex, SemaphoreInterface semaphore) {
        this.threadIndex = threadIndex;
        this.semaphore = semaphore;
    }
        @Override
        public void run() {
            try {
                System.out.println("Start of thread #" + threadIndex);

                //���� �������� ����� �������� � ���� �� �, �� ������ ����. ���� � - ����.
                semaphore.acquire();

                //������� �������� ������
                synchronized (this) {
                    counter++;
                    System.out.println("Critical section. Thread #" + threadIndex + ". Counter = " + counter);
                }
                semaphore.release();//�������� ������ ���������� - ������ �����.

                System.out.println("End of thread #" + threadIndex);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
