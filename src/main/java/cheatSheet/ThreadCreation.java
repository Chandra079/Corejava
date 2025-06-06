package cheatSheet;

public class ThreadCreation {
    public static void main(String[] args) {
     /*   Runnable runnable = ()->{
            for (int i = 0; i <1000; i++) {
                System.out.println("Thread is Running and Started ");
            }

        };

        new Thread(()->{
            for (int i = 0; i <1000; i++) {
                System.out.println("One mOre Child Methods");
            }
        }).start();


        Thread thread = new Thread(runnable);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main Thread");
        }


        new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("New THREAD Was Created ");
            }

        }).start();

        */

        /// restart

        Runnable runnable1 = ()->{
            System.out.println("Test Thread ");
        };

        new Thread(runnable1).start();



      ThreadClass threadClass = new ThreadClass();

      threadClass.start();
    }
}

class ThreadClass extends Thread{

    @Override
    public void run() {
        System.out.println("From Thread Class");
    }
}
