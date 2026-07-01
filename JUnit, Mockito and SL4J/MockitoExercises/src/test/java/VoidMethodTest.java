import org.junit.Test;

import static org.mockito.Mockito.*;

public class VoidMethodTest {

    @Test
    public void testVoidMethod() {

        ExternalApi mockApi = mock(ExternalApi.class);

        doNothing().when(mockApi).sendMessage("Hello");

        mockApi.sendMessage("Hello");

        verify(mockApi).sendMessage("Hello");

    }
}