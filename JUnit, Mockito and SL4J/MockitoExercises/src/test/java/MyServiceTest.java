import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        // Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject mock
        MyService service = new MyService(mockApi);

        // Test
        String result = service.fetchData();

        // Verify output
        assertEquals("Mock Data", result);

    }
}