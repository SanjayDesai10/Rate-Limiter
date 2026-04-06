package RateLimiter;

public class RemoteResource implements Resource {
    Response result;
    String name;
    int id;

    public Response getResult(Request m) {
        if (m.id >= 0) {
            String username = m.username;
            String ans = username + "'s IPL team";
            result = new Response(ans);
            return result;
        }
        return new Response("Your IPL team does not exist");
    }
}
