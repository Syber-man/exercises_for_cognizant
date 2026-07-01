import org.junit.Test;

import static org.mockito.Mockito.*;

public class VerifyInteractionTest {

    @Test
    public void testVerifyInteraction() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }
}