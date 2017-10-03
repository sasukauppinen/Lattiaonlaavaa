package fi.kittaamo.apps.lattiaonlaavaa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeFrameRandomizerTest {
    @Test
    public void getNextTest() throws Exception {
        TimeFrameRandomizer dut = new TimeFrameRandomizer(23, 56);
        int val = dut.GetNext();
        assertTrue("minValue set", dut.getMinValue() == 23);
        assertTrue("maxValue set", dut.getMaxValue() == 56);
        assertTrue("val not below lower bound", val >= dut.getMinValue());
        assertTrue("val not above upper bound", val <= dut.getMaxValue());
    }
}

