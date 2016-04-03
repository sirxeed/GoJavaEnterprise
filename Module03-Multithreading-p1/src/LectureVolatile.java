public class LectureVolatile {
    private volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Worker()).start();
        Thread.sleep(5);
        flag = false;
    }

    public static class Worker implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (flag) {
                i++;
            }
            System.out.println(i);
        }
    }
}
