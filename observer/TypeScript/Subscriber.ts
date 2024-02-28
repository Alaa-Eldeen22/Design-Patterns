export default interface Subscriber {
  update(eventType: string): void;
}
