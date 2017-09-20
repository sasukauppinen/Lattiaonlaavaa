package fi.kittaamo.apps.lattiaonlaavaa;

import java.security.SecureRandom;

/**
 * Create random numbers
 */

class TimeFrameRandomizer {

    private int minValue;
    private int maxValue;

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

        result = rnd.nextInt(maxValue-minValue) + minValue;

        return result;
    }
}
