import ConcretePublisher from "./ConcretePublisher";

export default class Store extends ConcretePublisher {
  // Constructor calls super constructor with given events
  constructor(events: string[]) {
    super(events);
  }

  // Method to update subscribers about tech products
  updateTechProducts(): void {
    this.notify("tech products");
  }

  // Method to update subscribers about sports products
  updateSportsProducts(): void {
    this.notify("sports products");
  }
}
