import Subscriber from "./Subscriber";

export default class Customer implements Subscriber {
  update(eventType: string): void {
    console.log(`A new ${eventType} arrived! Great!!`);
  }
}
