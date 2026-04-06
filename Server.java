package RateLimiter;

public class Server {
    Resource resource;

    public Server(Resource resource) {
        this.resource = resource;
    }

    public Response getIplTeam(Request request) {
        Response response = resource.getResult(request);
        return response;
    }
}
