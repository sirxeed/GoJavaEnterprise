import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class LectureAtomic {

    private AtomicInteger counter = new AtomicInteger(0);
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new LectureAtomic().test();
    }

    public int increment() {
        return counter.incrementAndGet();
        //return counter++;
    }

    public void test() throws InterruptedException {
        List<Aggregator> aggregators = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Aggregator aggregator = new Aggregator();
            aggregators.add(aggregator);
            new Thread(aggregator).start();
        }

        Thread.sleep(1000);
        boolean isValid = true;

        Set<Integer> integerSet = new HashSet<>();
        for (Aggregator aggregator : aggregators) {
            for (Integer anInt : aggregator.ints) {
                if (!integerSet.add(anInt)) {
                    System.out.println("Error! Duplicate found:" + anInt);
                    isValid = false;
                }
            }
        }
        if (isValid) {
            System.out.println("No duplicates");
        }
    }

    public class Aggregator implements Runnable {
        private List<Integer> ints = new ArrayList<>();

        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                ints.add(increment());
            }
        }
    }
}