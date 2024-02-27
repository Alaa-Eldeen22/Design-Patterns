// Customer implements the Subscriber interface
public class Customer implements Subscriber {

    // Method to update the customer about a new tech event
    public void update(String eventType) {
        System.out.println("A new tech " + eventType + " arrived! Great!!");
    };

}
