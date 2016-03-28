import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

public class LectureSynchronizers {

    public static void main(String[] args) throws InterruptedException {
        LectureSynchronizers synchronizers = new LectureSynchronizers();
        //synchronizers.testCyclicBarrier();
        synchronizers.testExchanger();
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

    public void testExchanger() throws InterruptedException {
        Random random = new Random();
        Exchanger<String> exchanger = new Exchanger<>();
        IntStream.range(0, 2).forEach((i) -> new Thread(() -> {
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " is ready to exchange");
                System.out.println(Thread.currentThread().getName() + " < - > " + exchanger.exchange(Thread.currentThread().getName()));
                exchanger.exchange(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }

}