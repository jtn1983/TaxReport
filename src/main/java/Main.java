import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder stat = new LongAdder();
        new Shop().generateList().
                forEach(i -> executorService.submit(() -> stat.add(i)));
        new Shop().generateList().
                forEach(i -> executorService.submit(() -> stat.add(i)));
        new Shop().generateList().
                forEach(i -> executorService.submit(() -> stat.add(i)));
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + stat.sum());
        executorService.shutdown();
    }
}
