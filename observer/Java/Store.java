public class Store extends ConcretePublisher {

    // Constructor calls super constructor with given events
    public Store(String... events) {
        super(events);
    }

    // Method to update subscribers about tech products
    public void updateTechProducts() {
        this.notify("tech products");
    }

    // Method to update subscribers about sports products
    public void updateSportsProducts() {
        this.notify("sports products");
    }

}
