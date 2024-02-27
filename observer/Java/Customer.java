public class Customer implements Subscriber {

    public void update(String eventType) {
        System.out.println("A new " + eventType + " arrived! Great!!");
    };

}
