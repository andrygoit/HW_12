package task1;

public class TimePassedPrinter {
    private static int pointStart = 1;

    public static void main(String[] args) {
        Runnable oneSecond = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(pointStart + "seconds passed");
                       try {
                           Thread.sleep(1000);
                    } catch (InterruptedException e){
                           e.getMessage();
                       }
                       pointStart++;
                }
            }
        };
        Runnable fiveSecond = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    if (pointStart % 5 == 0){
                        System.out.println("5 seconds passed");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e){
                            e.getMessage();
                        }
                    }
                }
            }
        };
        Thread t1 = new Thread(oneSecond);
        Thread t2 = new Thread(fiveSecond);
        t1.start();
        t2.start();
    }
}
