import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ArgumentMatcherTest {

    @Test
    public void testArgumentMatcher() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getUser(anyString())).thenReturn("User Found");

        String result = mockApi.getUser("Srutiman");

        assertEquals("User Found", result);

        verify(mockApi).getUser(anyString());
    }
}