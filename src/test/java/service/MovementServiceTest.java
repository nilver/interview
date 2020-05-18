package service;

import delivery.constants.MovementType;
import delivery.exception.SenderServiceException;
import delivery.model.Delivery;
import delivery.service.MovementService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementServiceTest {

    protected MovementService movementService;

    @Before
    public void setUp() {
        movementService = new MovementService();
    }

    @Test
    public void when_turnLeft_succes() {
        Delivery delivery = new Delivery(0);
        movementService.turnLeft(delivery);
        assertEquals(delivery.getDirection(), 3);
    }

    @Test
    public void when_turnRight_succes() {
        Delivery delivery = new Delivery(0);
        movementService.turnRight(delivery);
        assertEquals(delivery.getDirection(), 1);
    }

    @Test
    public void when_processMovement_with_goFoward_succes() throws SenderServiceException {
        Delivery delivery = new Delivery(0);
        movementService.setDelivery(delivery);
        movementService.processMovement(MovementType.A.name());
        assertEquals(delivery.getY(), 1);
    }

    @Test(expected = SenderServiceException.class)
    public void when_processMovement_with_InvalidMovement_then_Exception() throws SenderServiceException {
        Delivery delivery = new Delivery(0);
        movementService.setDelivery(delivery);
        movementService.processMovement("K");
    }

    @Test
    public void when_turnRight_twice_succes() {
        Delivery delivery = new Delivery(0);
        movementService.turnRight(delivery);
        movementService.turnRight(delivery);
        assertEquals(delivery.getDirection(), 2);
    }
}
