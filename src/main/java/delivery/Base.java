package delivery;

import delivery.delegate.DispaherDelegate;

import javax.print.DocFlavor;

/**
 * @author nilver
 * @version 1.0.0
 * @since 1.0.0
 */
public class Base {

    public static void main(String[] args) {
        int totalDrones = 4;
        int capacity = 3;
        int range = 10;

        if(args.length==3){
            totalDrones = Integer.parseInt(args[0]);
            capacity = Integer.parseInt(args[1]);
            range = Integer.parseInt(args[2]);
        }
        new DispaherDelegate(totalDrones).init(range, capacity);

    }
}
