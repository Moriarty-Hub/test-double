package mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SecurityCenterTest {
    /* 需求描述：
    编写SecurityCenter类的单元测试，单元测试switchOn方法，不依赖于DoorPanel的close的方法实现
    * */

    private DoorPanel doorPanel;
    private SecurityCenter securityCenter;

    @BeforeEach
    public void setUp() {
        doorPanel = Mockito.mock(DoorPanel.class);
        securityCenter = new SecurityCenter(doorPanel);
    }

    @Test
    public void shouldVerifyDoorIsClosed() {
        verify(doorPanel, times(0)).close();
        securityCenter.switchOn();
        verify(doorPanel, times(1)).close();
    }
}
