package delivery;

import delivery.delegate.DispaherDelegate;

/**
 * @author nilver
 * @version 1.0.0
 * @since 1.0.0
 */
public class Base {

    public static void main(String[] args) {
        int totalDrones = 1;
        int capacity = 3;
        int range = 10;
        new DispaherDelegate(totalDrones).init(range, capacity);

    }
}
