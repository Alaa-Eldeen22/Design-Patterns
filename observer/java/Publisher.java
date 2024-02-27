// Publisher interface defines methods for subscribing,
// unsubscribing, and notifying subscribers
public interface Publisher {

    public void subscribe(String eventType, Subscriber s);

    public void unsubscribe(String eventType, Subscriber s);

    public void notify(String eventType);
}
