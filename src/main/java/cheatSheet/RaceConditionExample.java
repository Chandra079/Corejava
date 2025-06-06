package cheatSheet;

public class RaceConditionExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
            sharedResource.increment();
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
                sharedResource.increment();
            }
        });
        
    }
}

class SharedResource {
    private int count = 0;

    public void increment() {
        count++;  // This is a critical section
    }

    public int getCount() {
        return count;
    }
}


