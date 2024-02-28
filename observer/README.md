# Observer Pattern

![Observer Pattern](https://refactoring.guru/images/patterns/content/observer/observer.png)

Image source: [Refactoring Guru](https://refactoring.guru/design-patterns/observer)

## Table of Contents

1. [Overview](#overview)
2. [Problem](#problem)
3. [Solution](#solution)
4. [Implementation](#implementation)
5. [Key Concepts](#key-concepts)
6. [Benefits of Observer Pattern](#benefits-of-observer-pattern)
7. [Summary](#summary)
8. [Java Implementation](#java-implementation)
9. [TypeScript Implementation](#typescript-implementation)
10. [How to Run](#how-to-run)
11. [Found an Issue?](#found-an-issue)

## Overview

The Observer pattern is a behavioral design pattern that allows you to define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing. It establishes a one-to-many dependency between objects, ensuring that when one object changes state, all of its dependents are notified and updated automatically.

## Problem

To illustrate the problem with a real-life analogy: imagine you're a store owner, and there's a customer interested in a particular product that's currently out of stock but expected to arrive soon. The customer could visit the store every day to check the product's availability, which would waste his time. Conversely, the store could send out numerous emails (potentially seen as spam) to all customers every time a new product becomes available. While this would save the interested customer's time, it could annoy others.

## Solution

Now, if we create a system for our store, we initially have two objects: `Store` and `Customer`. We need to notify the interested customers every time a new product becomes available without annoying those who are not interested. This is where the observer pattern comes in.

We have an object that has state that other objects are interested in, so we will name the first the `publisher` or the `subject` (which is the `Store` object in our case) and the ones that want to track its state as `observers` or `subscribers` (which are the customers in our case). Every object can register or remove itself as a subscriber.

We could also categorize our subscribers according to their interests (i.e., some interested in tech products and others interested in sports products and so on). One of the greatest benefits of the Observer is that we can dynamically add and remove subscribers at runtime by providing `subscribe(eventType, subscriber)` and `unsubscribe(eventType, subscriber)` methods. Great! Isn't it?

Moreover, all subscribers must implement an interface that defines the methods required for notification. This interface ensures that subscribers adhere to a specific contract, enabling seamless integration into the observer pattern.

The notification mechanism works using two essential methods: the `notify` method, which will be called by the `Publisher` when its state changes, and the `update` methods, which will be provided by subscribers to handle this change.

## Implementation

The implementation consists of several Java classes:

1. **ConcretePublisher** [Java](Java/ConcretePublisher.java) | [TypeScript](TypeScript/ConcretePublisher.ts):

   - The `ConcretePublisher` class implements the `Publisher` interface.
   - It maintains a map of subscribers (`subscribers`) where the key is the event type, and the value is a list of subscribers interested in that event.
   - The `subscribe` method allows subscribers to subscribe to a specific event type.
   - The `unsubscribe` method allows subscribers to unsubscribe from a specific event type.
   - The `notify` method is responsible for notifying all subscribers interested in a particular event type when that event occurs.

2. **Customer** [Java](Java/Customer.java) | [TypeScript](TypeScript/Customer.ts):

   - The `Customer` class implements the `Subscriber` interface.
   - It provides the `update` method, which defines how a subscriber reacts to receiving a notification about a specific event type.

3. **Publisher Interface** [Java](Java/Publisher.java) | [TypeScript](TypeScript/Publisher.ts):

   - The `Publisher` interface defines methods for subscribing, unsubscribing, and notifying subscribers.

4. **Subscriber Interface** [Java](Java/Subscriber.java) | [TypeScript](TypeScript/Subscriber.ts):

   - The `Subscriber` interface declares the notification interface.
     In most cases, it consists of a single update method. The
     method may have several parameters that let the publisher
     pass some event details along with the update.

5. **Store Class** [Java](Java/Store.java) | [TypeScript](TypeScript/Store.ts):

   - The `Store` class extends `ConcretePublisher`.
   - It represents the concrete implementation of the publisher.
   - It provides methods to update subscribers about different types of products (tech products and sports products).

6. **Client** [Java](Java/Client.java) | [TypeScript](TypeScript/Client.ts)
   :

   - Testing and demonstration of the Observer pattern occur.
   - It creates instances of the `Store` class, representing the publisher, and `Customer` class, representing subscribers.
   - It subscribes customers (`techCustomer` and `sportsCustomer`) to different event types (tech products and sports products).
   - It triggers updates in the store for different product types (`updateTechProducts` and `updateSportsProducts` methods).
   - It demonstrates the functionality of subscribing, unsubscribing, and notifying subscribers based on events.

## Key Concepts:

- **Subject (`Publisher`)**: The object being observed. In this case, it's the `Store` object.
- **Observer (`Subscriber`)**: The objects observing the subject for changes. In this case, they are instances of the `Customer` class.
- **Subscription**: The process by which observers register themselves with the subject to receive notifications.
- **Unsubscription**: The process by which observers can unregister themselves from receiving further notifications.
- **Notification**: The process by which the subject informs all registered observers about a change in its state.
- **Event Type**: A specific category or type of event that observers can subscribe to.

## Benefits of Observer Pattern:

- **Loose Coupling**: The subject and observers are loosely coupled. They can interact without having explicit knowledge of each other.
- **Dynamic Subscription**: Observers can subscribe and unsubscribe at runtime, allowing for flexibility and scalability.
- **Separation of Concerns**: The subject is responsible for managing its state, while observers are responsible for reacting to changes, promoting a separation of concerns.
- **Open/Closed Principle**: You can introduce new subscriber classes without having to change the publisher’s code, and vice versa if there’s a publisher interface. This adheres to the Open/Closed Principle, promoting extensibility and maintainability.
- **Establish Relations at Runtime**: The Observer pattern allows you to establish relations between objects at runtime, providing flexibility and adaptability in complex systems.

## Summary:

The Observer pattern facilitates communication between objects in a loosely coupled manner. It enables objects to observe and react to changes in the state of another object without needing direct dependencies. This promotes modularity, flexibility, and maintainability in software design.

## Java Implementation

The Java implementation of the Observer pattern is provided in the `observer/Java` directory.

## TypeScript Implementation

The TypeScript implementation of the Observer pattern is provided in the `observer/TypeScript` directory.

## How to Run

Before running either the Java or TypeScript implementation, make sure you've cloned the repository:

```bash
git clone https://github.com/Alaa-Eldeen22/Design-Patterns.git
```

To run the Java implementation:

1. Navigate to the `observer/Java` directory:

   ```bash
   cd Design-Patterns/observer/Java
   ```

2. Make sure you have JDK (Java Development Kit) installed on your system. You can download and install it from the official Oracle website or use OpenJDK if you prefer.

3. Compile the Java code using `javac`:

   ```bash
   javac *.java
   ```

   This command will compile all the Java files in the directory.

4. Run the main class using `java`:

   ```bash
   java Client
   ```

   This command will execute the Java code and demonstrate the Observer pattern implementation.

To run the TypeScript implementation:

1. Navigate to the `observer/TypeScript` directory:

   ```bash
   cd Design-Patterns/observer/TypeScript
   ```

2. Install `ts-node` if you haven't already:

   ```bash
   npm install -g ts-node
   ```

3. Run the TypeScript code using `ts-node`:

   ```bash
   ts-node Client.ts
   ```

   This command will execute the TypeScript code and demonstrate the Observer pattern implementation.

---

## Found an Issue?

If you notice any discrepancies, bugs, or have suggestions for improvement, don't hesitate to open an issue on the [GitHub repository](https://github.com/Alaa-Eldeen22/Design-Patterns).
