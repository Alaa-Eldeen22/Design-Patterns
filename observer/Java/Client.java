public class Client {
    public static void main(String[] args) {
        // Create a store instance
        Store store = new Store("tech products", "sports products");

        // Create subscribers
        Customer techCustomer = new Customer();
        Customer sportsCustomer = new Customer();

        // Subscribe customers to events
        store.subscribe("tech products", techCustomer);
        store.subscribe("sports products", sportsCustomer);

        // Notify subscribers about updates
        store.updateTechProducts();
        store.updateSportsProducts();

        // Unsubscribe a customer
        store.unsubscribe("tech products", techCustomer);

        // Notify again after unsubscribe
        store.updateTechProducts();
    }
}
