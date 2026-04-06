package RateLimiter;

public class ProxyRemoteResource implements Resource {
    String name;
    RemoteResource remoteResource;
    IStrategy strategy;

    public ProxyRemoteResource(IStrategy strategy) {
        this.strategy = strategy;
    }

    public RemoteResource getRemoteResource() {
        if (remoteResource == null) {
            remoteResource = new RemoteResource();
        }
        return remoteResource;
    }

    public Response getResult(Request m) {
        if (strategy.isAllowed(m)) {
            return getRemoteResource().getResult(m);
        }
        return new Response("CODE: 429 , too many requests");
    }
}
