# Rate Limiter
![alt text](<Rate Limiter.drawio.png>)
A low-level design implementation of the **Rate Limiter** pattern using the **Proxy Design Pattern** and **Sliding Window** strategy in Java.

## Design Patterns Used

- **Proxy Pattern** — `ProxyRemoteResource` acts as a proxy to `RemoteResource`, intercepting requests to enforce rate limits.
- **Strategy Pattern** — `IStrategy` interface allows plugging in different rate-limiting algorithms.

## Classes

| Class | Description |
|---|---|
| `App` | Entry point; creates requests and sends them through the server |
| `Server` | Accepts requests and delegates to the resource |
| `Resource` | Interface for any resource |
| `RemoteResource` | The actual resource that processes requests |
| `ProxyRemoteResource` | Proxy that enforces rate limiting before forwarding |
| `IStrategy` | Strategy interface for rate-limiting logic |
| `SlidingWindowStrategy` | Allows N requests per T seconds using a sliding window |
| `Request` | Represents an incoming request with a timestamp |
| `Response` | Represents the result of a request |

## How It Works

1. Requests go to `Server` → `ProxyRemoteResource`.
2. The proxy checks `SlidingWindowStrategy.isAllowed()`.
3. If within limits → forwarded to `RemoteResource`.
4. If exceeded → returns `429 Too Many Requests`.

## Running

```bash     
javac RateLimiter/*.java
java RateLimiter.App
```
