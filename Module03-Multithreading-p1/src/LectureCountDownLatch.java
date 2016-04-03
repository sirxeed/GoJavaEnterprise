public class LectureCountDownLatch {
    private int counter = 0;
    private final Object lock = new Object();

    public static void main(String[] args) {
        new LectureLatchBootStrap().test();
    }

    public LectureCountDownLatch(int counter) {
        this.counter = counter;
    }


    public void await() throws InterruptedException {
        synchronized (lock) {
            if (counter > 0) {
                lock.wait();
            }
        }
    }

    public void countDown() {
        synchronized (lock) {
            if (counter > 0) {
                counter--;
                System.out.println("Counter = " + counter);
            }

            if (counter == 0) {
                lock.notifyAll();
            }
        }
    }

    public int getCounter() {
        synchronized (lock) {
            return counter;
        }
    }
}
