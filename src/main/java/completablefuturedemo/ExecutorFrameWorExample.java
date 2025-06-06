package completablefuturedemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFrameWorExample {
    public static void main(String[] args) {
        System.out.println("ExecuotFrameworkExample Started");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+" executing Task ");
            });
        }

        executorService.shutdown();


        Callable<Integer> callable = ()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("Callable Task is Running");
            }
            return 100;
        };
        ExecutorService executorServiceNew = Executors.newFixedThreadPool(5);

        Future<Integer> future = executorServiceNew.submit(callable);
        try {
            Integer result = future.get(); // Blocks and waits for result
            System.out.println("Sum is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorServiceNew.shutdown();


    }
}
