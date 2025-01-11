package completablefuturedemo;

import java.util.concurrent.CompletableFuture;

public class NonBlockingMainThread {
    public static void main(String[] args) {
        System.out.println("Main thread starts: " + Thread.currentThread().getName());

        // Create a CompletableFuture that simulates a long-running operation
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Starting async task: " + Thread.currentThread().getName());
            try {
                // Simulate a delay
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Async task completed: " + Thread.currentThread().getName());
        });

        // Non-blocking operations in the main thread
        System.out.println("Main thread continues without waiting...");

        // Wait for the CompletableFuture to complete (optional, for demonstration)
        future.join();

        System.out.println("Main thread ends: " + Thread.currentThread().getName());
    }
}
