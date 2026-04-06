package RateLimiter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Request {
    int id;
    static AtomicInteger ai = new AtomicInteger();
    String username;
    LocalDateTime date;

    public Request(String username) {
        this.id = ai.getAndIncrement();
        this.username = username;
        this.date = LocalDateTime.now();
    }
}
