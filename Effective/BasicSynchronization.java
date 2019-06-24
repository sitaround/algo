package Effective;

public class BasicSynchronization { 
    private String mMessage;
    public static void main(String[] agrs) {
        BasicSynchronization temp = new BasicSynchronization();
        System.out.println("Test start!");
        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                temp.callMe("Thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                temp.callMe("Thread2");
            }
        }).start();

        System.out.println("Test end!");
    }
    
    public synchronized void callMe(String whoCallMe) {  //void 앞에 synchronized 키워드를 사용하면 메인의 쓰레드들이 이 함수에 대해 하나의 쓰레드가 작업을 끝내면 그 후에 다른 쓰레드가 작업을 시작.
        mMessage = whoCallMe;
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!mMessage.equals(whoCallMe)) {
            System.out.println(whoCallMe + " | " + mMessage);
        }
    }
}