import org.junit.Test;

import static org.mockito.Mockito.*;

public class VoidExceptionTest {

    @Test(expected = RuntimeException.class)
    public void testVoidException() {

        ExternalApi mockApi = mock(ExternalApi.class);

        doThrow(new RuntimeException())
                .when(mockApi)
                .sendMessage("Hello");

        mockApi.sendMessage("Hello");

    }
}