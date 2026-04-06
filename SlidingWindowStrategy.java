package RateLimiter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowStrategy implements IStrategy {
    Queue<Request> queue;
    private int TimeLimit;
    private int RequestLimit;

    public SlidingWindowStrategy(int timeLimit, int requestLimit) {
        queue = new LinkedList<>();
        this.TimeLimit = timeLimit;
        this.RequestLimit = requestLimit;
    }

    public void updateQueue(LocalDateTime now) {
        while (!queue.isEmpty() && ChronoUnit.SECONDS.between(queue.peek().date, now) >= this.TimeLimit) {
            queue.poll();
        }
    }

    // per 3 sec only 4 requests
    public boolean isAllowed(Request request) {
        LocalDateTime now = LocalDateTime.now();
        updateQueue(now);
        if (queue.size() < RequestLimit) {
            queue.add(request);
            return true;
        }
        return false;
    }
}
