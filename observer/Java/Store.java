// Store class extends ConcretePublisher
public class Store extends ConcretePublisher {

    // Constructor calls super constructor with given events
    public Store(String... events) {
        super(events);
    }

    // Method to update subscribers about tech products
    public void updateTechProducts() {
        notify("tech products");
    }

    // Method to update subscribers about sports products
    public void updateSportsProducts() {
        notify("sports products");
    }

}
