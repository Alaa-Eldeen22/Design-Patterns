import Customer from "./Customer";
import Store from "./Store";

const store = new Store(["tech products", "sports products"]);

// Create subscribers
const techCustomer = new Customer();
const sportsCustomer = new Customer();

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
