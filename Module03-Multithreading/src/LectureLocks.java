import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LectureLocks {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LectureLocks locks = new LectureLocks();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            locks.testTryLock();
                        }
                    }).start();
        }
    }

    public void testLock() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " tries to get lock");
        lock.lock();
        //lock.lockInterruptibly();
        try {
            System.out.println(threadName + " executing critical section");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(threadName + " releasing lock");
            lock.unlock();
        }
    }

    public void testTryLock() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " tries to get lock");
        try {
            if (lock.tryLock(200, TimeUnit.MILLISECONDS)) {

                try {
                    System.out.println(threadName + " executing critical section");
                    Thread.sleep(100);
                } finally {
                    System.out.println(threadName + " releasing lock");
                    lock.unlock();
                }
            } else {
                System.out.println(threadName + " unable to acquire a lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}