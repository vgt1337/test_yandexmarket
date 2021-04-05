package org.tn;

import org.junit.Test;

public class MainTest extends BaseTest
{
    @Test()
    public void Test()
    {
        WaitUntil.ShouldLocate( _webDriver, TestSettings.HostPrefix);
    }

}
