package delivery.service;

import delivery.constants.DirectionType;
import delivery.constants.MovementType;
import delivery.exception.SenderServiceException;
import delivery.model.Delivery;

/**
 * @author nilver
 * @version 1.0.0
 * @since 1.0.0
 */
public class MovementService {

    private Delivery delivery;
    private final static String INVALID_MOVEMENT = "Invalid movement to process: ";
    private final static String INVALID_RANGE = "Invalid movement, it can not be upper that range: ";

    public MovementService() {
    }

    /**
     * SetUp initial delivery
     *
     * @param delivery
     */
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    /**
     * Set a left movement
     *
     * @param delivery
     */
    public void turnLeft(Delivery delivery) {
        int direction = delivery.getDirection();
        direction = (4 + direction - 1) % 4;
        delivery.setDirection(direction);

    }

    /**
     * Set a right movement
     *
     * @param delivery
     */
    public void turnRight(Delivery delivery) {
        int direction = delivery.getDirection();
        direction = (direction + 1) % 4;
        delivery.setDirection(direction);

    }

    /**
     * Set a go ahead movement for delivery
     * @param delivery
     */
    public void goForward(Delivery delivery) {

        int direction = delivery.getDirection();
        int x = delivery.getX();
        int y = delivery.getY();

        switch (direction) {
            case 0:
                delivery.setY(++y);
                break;
            case 1:
                delivery.setX(++x);
                break;
            case 2:
                delivery.setY(--y);
                break;
            case 3:
                delivery.setX(--x);
                break;
        }
    }

    /**
     * Process a valid movement(forward,left,right)
     * @param movement
     * @throws SenderServiceException when get a invalid movement
     */
    public void processMovement(String movement) throws SenderServiceException {

        switch (getMovementType(movement)) {
            case A:
                goForward(delivery);
                break;
            case I:
                turnLeft(delivery);
                break;
            case D:
                turnRight(delivery);
                break;
        }
    }

    /**
     * Validate if the string is a valid
     * @param movement
     * @return
     * @throws SenderServiceException
     */
    private MovementType getMovementType(String movement) throws SenderServiceException {
        try {
            return MovementType.valueOf(movement);
        } catch (IllegalArgumentException e) {
            throw new SenderServiceException(INVALID_MOVEMENT + movement);
        }
    }

    private DirectionType getDirectionType(String movement) throws SenderServiceException {
        try {
            return DirectionType.valueOf(movement);
        } catch (IllegalArgumentException e) {
            throw new SenderServiceException(INVALID_MOVEMENT + movement);
        }
    }

    public void validateRange(int range) throws SenderServiceException {
        if (delivery.getY() > range && delivery.getX() > 10) {
            throw new SenderServiceException(INVALID_RANGE + range);
        }
    }

}
