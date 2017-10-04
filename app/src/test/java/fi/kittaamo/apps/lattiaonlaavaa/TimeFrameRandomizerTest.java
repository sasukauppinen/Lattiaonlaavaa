package fi.kittaamo.apps.lattiaonlaavaa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeFrameRandomizerTest {
    @Test
    public void getNextTest() throws Exception {
        TimeFrameRandomizer dut;
        for (int i=0; i<20; i++) {
            dut = new TimeFrameRandomizer(23, 56);
            int val = dut.GetNext();
            System.out.println("val1= " + val);
            assertTrue("minValue set", dut.getMinValue() == 23);
            assertTrue("maxValue set", dut.getMaxValue() == 56);
            assertTrue("val not below lower bound", val >= dut.getMinValue());
            assertTrue("val not above upper bound", val <= dut.getMaxValue());
        }

        for (int i=0; i<20; i++) {
            TimeFrameRandomizer narrowGap = new TimeFrameRandomizer(55, 57);
            int val2 = narrowGap.GetNext();
            System.out.println("val2= " + val2);
            assertTrue("minValue set", narrowGap.getMinValue() == 55);
            assertTrue("maxValue set", narrowGap.getMaxValue() == 57);
            assertTrue("val not below lower bound", val2 >= narrowGap.getMinValue());
            assertTrue("val not above upper bound", val2 <= narrowGap.getMaxValue());
        }

    }
}

