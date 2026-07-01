import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class InteractionOrderTest {

    @Test
    public void testInteractionOrder() {

        ExternalApi mockApi = mock(ExternalApi.class);

        mockApi.connect();

        mockApi.getData();

        mockApi.disconnect();

        InOrder order = inOrder(mockApi);

        order.verify(mockApi).connect();

        order.verify(mockApi).getData();

        order.verify(mockApi).disconnect();

    }
}