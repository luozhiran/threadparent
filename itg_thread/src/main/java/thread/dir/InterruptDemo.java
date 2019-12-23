package thread.dir;

public class InterruptDemo {

    private Thread mThread;
    private boolean isStart;
    private int mCount;

    public InterruptDemo(String name) {
        mThread = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        System.err.println(mCount++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.err.println("接收到终端异常");
                }
            }
        }, name);
    }

    public void start() {
        if (!isStart) {
            isStart = true;
            mThread.start();
        }
    }

    public void finish() {
        if (isStart) {
            mThread.interrupt();
        }
    }
}
