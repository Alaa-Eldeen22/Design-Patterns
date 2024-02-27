import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ConcretePublisher implements the Publisher interface
public class ConcretePublisher implements Publisher {

    // Map to store subscribers for each event type
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    // Constructor initializes subscribers map for given events
    public ConcretePublisher(String... events) {

        for (String event : events) {
            this.subscribers.put(event, new ArrayList<>());
        }
    }

    // Method to subscribe a subscriber to a specific event type
    public void subscribe(String eventType, Subscriber s) {
        List<Subscriber> eventSubscribers = this.subscribers.get(eventType);
        if (eventSubscribers != null) {
            eventSubscribers.add(s);
        } else {
            System.out.println(eventType + "does not exist");
        }
    };

    // Method to unsubscribe a subscriber from a specific event type
    public void unsubscribe(String eventType, Subscriber s) {
        List<Subscriber> eventSubscribers = this.subscribers.get(eventType);
        if (eventSubscribers != null) {
            eventSubscribers.remove(s);
        } else {
            System.out.println(eventType + "does not exist");
        }
    };

    // Method to notify subscribers of a specific event
    public void notify(String eventType) {
        List<Subscriber> eventSubscribers = this.subscribers.get(eventType);
        if (eventSubscribers.size() > 0) {
            for (Subscriber subscriber : eventSubscribers) {
                subscriber.update(eventType);
            }
        } else {
            System.out.println("No subscribers for event type: " + eventType);
        }
    }

}
