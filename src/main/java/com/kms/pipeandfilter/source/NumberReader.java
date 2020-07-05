package com.kms.pipeandfilter.source;

import com.kms.pipeandfilter.pipe.IPipe;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class NumberReader extends AbstractReader<Integer> {
    public NumberReader(IPipe<Integer> input) {
        super(input);
    }

    @Override
    public void generateInto(IPipe<Integer> pipe) {
        for (int i = 1; i <= 1; i++) {
            int randomNumber = new Integer(getRandomNumberInRange(1, 10));
            pipe.put(randomNumber);
            log.info("Generate random number: {}", randomNumber);
            delayForDebug(200);
        }
        pipe.closeForWriting();
        log.info("Filter finished");
    }

    /**
     * Generate a random number in range (min, max)
     * @param min
     * @param max
     * @return
     */
    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
