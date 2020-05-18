package delivery.service;

import delivery.exception.SenderServiceException;
import delivery.model.Delivery;
import delivery.model.Drone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Nilver Viera
 * @version 1.0.0
 * @since 1.0.0
 */
public class SenderService extends Thread {

    private String id;
    private FileService fileService;
    private  MovementService movementService;
    private List<String> result = new ArrayList<>();
    private int capacity;
    private int range;
    private static final String ERROR_CAPACITY = "Capacity can no be upper that: ";

    public SenderService(String id, int range, int capacity) {
        this.id = id;
        this.fileService = new FileService();
        this.movementService = new MovementService();
        this.range = range;
        this.capacity = capacity;
    }

    /**
     * This method is called when a thread start, read a file and process all paths and movements.
     *
     */
    @Override
    public void run() {

        Map<String, Integer> paths = fileService.getMovements(id);
        paths.forEach(
                (path,ocurrecies) -> {
                    try {
                        processPath(path,ocurrecies,result);
                    } catch (SenderServiceException e) {
                        e.printStackTrace();
                    }
                }
        );
        fileService.writeFile(result, id);

    }

    /**
     *
     * @param path All movements far some path
     * @param ocurrencies number of food for some path
     * @param result final list with positions for some drone
     * @throws SenderServiceException when there is an invalid movement
     */
    private void processPath(String path,int ocurrencies, List<String> result) throws SenderServiceException {
        int capacity = setCapacity(ocurrencies);
        Delivery drone = new Drone(capacity);
        for (int j = 0; j < path.length(); j++) {
            String motion = path.substring(j, j + 1);
            this.movementService.setDelivery(drone);
            this.movementService.processMovement(motion);
            this.movementService.validateRange(this.range);
        }
        result.add(drone.toString());
    }

    /**
     * Validation if capacity is upper than the allowed
     * @param occurrences number of times that a order repeat
     * @return valid capacity
     * @throws SenderServiceException when capacity is upper than allowed
     */
    private int setCapacity(int occurrences) throws SenderServiceException {
        if(occurrences<=this.capacity){
            return occurrences;
        }else {
            throw new SenderServiceException(ERROR_CAPACITY + this.capacity);
        }
    }
}
