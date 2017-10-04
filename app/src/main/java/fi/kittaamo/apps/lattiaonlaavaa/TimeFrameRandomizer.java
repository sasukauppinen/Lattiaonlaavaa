package fi.kittaamo.apps.lattiaonlaavaa;

import java.security.SecureRandom;

/**
 * Create random numbers
 */

class TimeFrameRandomizer {

    private final int minValue;
    private final int maxValue;

    /** Create new TimeFrameRandomizer
        @param min lowest possible int value out of this randomizer
        @param max highest possible int value out of this randomizer
    */
    TimeFrameRandomizer(int min, int max) {
        this.minValue = min;
        this.maxValue = max;
    }

    int GetNext() {
        int result;
        SecureRandom rnd = new SecureRandom();

        //                      57      55          55
        result = rnd.nextInt(maxValue-minValue+1) + minValue;

        return result;
    }

    int getMinValue() {
        return minValue;
    }

    int getMaxValue() {
        return maxValue;
    }
}
