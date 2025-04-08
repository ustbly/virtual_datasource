package mock_data;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestScheduler {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        scheduler.scheduleAtFixedRate(() -> {
            try {
                int currentCount = count.incrementAndGet();
                System.out.println("[定时任务] 第 " + currentCount + " 次执行, 时间：" + Instant.now());

                // ✅ 模拟更新逻辑
                // 比如模拟耗时操作 Thread.sleep(100);
                // Thread.sleep(100);

                // ❌ 可以故意抛异常测试崩溃情况
                // if (currentCount == 10) throw new RuntimeException("模拟异常");

            } catch (Exception e) {
                System.err.println("定时任务出错：" + e.getMessage());
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);

        // ✅ 主线程等待，不让 JVM 提前退出
        keepRunning();
    }

    private static void keepRunning() {
        try {
            // 让 main 线程持续运行，防止守护线程自动退出
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.err.println("主线程中断：" + e.getMessage());
        }
    }
}

