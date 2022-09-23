public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread chicken = new MyThread("Курица");
        MyThread egg = new MyThread("Яйцо");

        chicken.start();
        egg.start();

        chicken.join();

        if(egg.isAlive()){
            egg.join();
            System.out.println("Победило яйцо");
        }else{
            System.out.println("Курица победила");
        }
    }
}
class MyThread extends Thread {

    MyThread(String name){
        super(name);
    }

    public void run(){

        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}