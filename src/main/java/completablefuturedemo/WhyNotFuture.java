package completablefuturedemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("WhyNotFuture Started..");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        
        Future<List<Integer>> future = executorService.submit(() -> {
            delay(1);
            System.out.println("Your API calling From "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4);
        });
        List<Integer> integers = future.get();
        System.out.println(integers);

        for (int i = 0; i < 100; i++) {
            System.out.println("After thread");
        }


        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.get();
    }

    private  static void  delay(int i){
        try {
            Thread.sleep(i*600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
