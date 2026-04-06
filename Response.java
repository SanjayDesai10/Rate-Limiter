package RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class Response {
    int id;
    static AtomicInteger ai = new AtomicInteger();
    String result;
    public Response(String result){
        this.id = ai.getAndIncrement();
        this.result = result;
    }
}
