import Publisher from "./Publisher";
import Subscriber from "./Subscriber";

export default abstract class ConcretePublisher implements Publisher {
  private subscribers: Map<string, Subscriber[]> = new Map();

  constructor(events: string[]) {
    events.forEach((event) => {
      this.subscribers.set(event, []);
    });
  }

  // Method to subscribe a subscriber to a specific event type
  subscribe(eventType: string, s: Subscriber): void {
    const eventSubscribers = this.subscribers.get(eventType);
    if (eventSubscribers) {
      eventSubscribers.push(s);
    } else {
      console.log(`${eventType} event does not exist`);
    }
  }

  // Method to unsubscribe a subscriber from a specific event type
  unsubscribe(eventType: string, subscriber: Subscriber): void {
    const eventSubscribers = this.subscribers.get(eventType);
    if (eventSubscribers) {
      const index = eventSubscribers.indexOf(subscriber);
      if (index !== -1) {
        eventSubscribers.splice(index, 1);
      }
    } else {
      console.log(`${eventType} event does not exist`);
    }
  }

  // Method to notify subscribers of a specific event
  notify(eventType: string): void {
    const eventSubscribers = this.subscribers.get(eventType);
    if (eventSubscribers?.length) {
      eventSubscribers.forEach((subscriber) => {
        subscriber.update(eventType);
      });
    } else {
      console.log(`No subscribers for event type: ${eventType}`);
    }
  }
}
