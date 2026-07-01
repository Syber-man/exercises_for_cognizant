import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MultipleReturnTest {

    @Test
    public void testMultipleReturns() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second")
                .thenReturn("Third");

        assertEquals("First", mockApi.getData());

        assertEquals("Second", mockApi.getData());

        assertEquals("Third", mockApi.getData());

    }
}