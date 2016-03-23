public class LectureLatchBootStrap {
    private LectureCountDownLatch lectureCountDownLatch;

    public void test() {
        lectureCountDownLatch = new LectureCountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker()).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (lectureCountDownLatch.getCounter() > 0) {
                    lectureCountDownLatch.countDown();
                }
            }
        }).start();
    }

    public class Worker implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " started to wait");
                lectureCountDownLatch.await();
                System.out.println("Thread " + Thread.currentThread().getName() + " stopped to wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
