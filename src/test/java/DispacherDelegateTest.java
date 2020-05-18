import delivery.delegate.DispaherDelegate;
import delivery.service.FileService;
import delivery.service.SenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DispacherDelegateTest {

    public final int totalDelivery = 2;

    @InjectMocks
    private DispaherDelegate dispaherDelegate = new DispaherDelegate(totalDelivery);

    @Mock
    private SenderService senderService;

    @Mock
    private FileService fileService;

    @Test
    public void when_init_success() {
        doNothing().when(senderService).run();
        doNothing().when(fileService).writeFile(anyList(),anyString());
        dispaherDelegate.init(10,3);
        assertEquals(dispaherDelegate.getTotalDelivery(), totalDelivery);
    }

    @Test
    public void when_create_dispaherDelegate_with_zero_then_totalDelivery_is_zero() {
        DispaherDelegate dispaherDelegate = new DispaherDelegate(0);
        assertEquals(dispaherDelegate.getTotalDelivery(),0);
    }
}
