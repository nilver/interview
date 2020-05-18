package delivery.delegate;

import delivery.service.SenderService;

import java.util.ArrayList;
import java.util.List;

public class DispaherDelegate {

    private int totalDelivery;
    private  List<String> namesFile = new ArrayList<>();

    public DispaherDelegate(int totalDelivery){
        this.totalDelivery = totalDelivery;
    }

    public void  init(int range, int capacity){
        createNamesFiles();
        for (String fileName :namesFile){
            Thread thread = new SenderService(fileName, range, capacity);
            thread.start();
        }
    }

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
