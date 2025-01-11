package completablefuturedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunAsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("RunAsyncDemo Started..");

        CompletableFuture<Void> inNewAsynchCode = CompletableFuture.runAsync(() -> {
            System.out.println("In New Asynch Code "+Thread.currentThread().getName());
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        for (int i = 0; i < 100; i++) {
            System.out.println("After thread");
        }
        inNewAsynchCode.thenRun(() -> System.out.println("Async task completed!"));

    }
}
