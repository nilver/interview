package delivery.delegate;

import delivery.service.SenderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nilver
 * @version 1.0.0
 * @since 1.0.0
 */
public class DispaherDelegate {

    private int totalDelivery;
    private  List<String> namesFile = new ArrayList<>();

    public DispaherDelegate(int totalDelivery){
        this.totalDelivery = totalDelivery;
    }

    /**
     * Create and start a thread for each order
     * @param range max to send orders
     * @param capacity max to each delivery
     */
    public void  init(int range, int capacity){
        createNamesFiles();
        for (String fileName :namesFile){
            Thread thread = new SenderService(fileName, range, capacity);
            thread.start();
        }
    }

    /**
     * Build a list of name for totalDelivery
     */
    private void createNamesFiles() {
        for (int i = 0; i < totalDelivery; i++) {
            int index = i + 1;
            String fileName = index + ".txt";
            this.namesFile.add(fileName);
        }
    }

    public int getTotalDelivery() {
        return totalDelivery;
    }
}
