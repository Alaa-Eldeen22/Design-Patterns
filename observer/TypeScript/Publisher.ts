import Subscriber from "./Subscriber";

// Publisher interface defines methods for subscribing,
// unsubscribing, and notifying subscribers
export default interface Publisher {
  subscribe(eventType: string, s: Subscriber): void;

  unsubscribe(eventType: string, s: Subscriber): void;

  notify(eventType: string): void;
}
