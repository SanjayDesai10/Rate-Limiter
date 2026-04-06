package RateLimiter;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Request> A = new ArrayList<>();
        Request first = new Request("mango");
        Request second = new Request("mango");
        Request third = new Request("mango");
        Request fourth = new Request("mango");
        Request fifth = new Request("mango");
        A.add(first);
        A.add(second);
        A.add(third);
        A.add(fourth);
        A.add(fifth);
        IStrategy strategy = new SlidingWindowStrategy(3, 4);
        Resource resource = new ProxyRemoteResource(strategy);
        Server server = new Server(resource);
        for (int i = 0; i < A.size(); i++) {
            Response res = server.getIplTeam(A.get(i));
            System.out.println(res.result);
        }

    }
}