import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LectureSynchronizers {

    public static void main(String[] args) throws InterruptedException {
        LectureSynchronizers synchronizers = new LectureSynchronizers();
        synchronizers.testCyclicBarrier();
    }

    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5);
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " started to wait on barrier");
                        barrier.await();
                        System.out.println(Thread.currentThread().getName() + " was last, so barrier has passed the thread");
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Thread.sleep(1000);
        }
    }

}