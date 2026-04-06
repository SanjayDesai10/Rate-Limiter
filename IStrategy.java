package RateLimiter;

public interface IStrategy {
    public boolean isAllowed(Request m);
}
