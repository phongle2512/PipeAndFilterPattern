package com.kms.pipeandfilter.source;

import com.kms.pipeandfilter.pipe.IPipe;
import com.kms.pipeandfilter.ThreadedRunner;

public abstract class AbstractReader<T> extends ThreadedRunner {
    protected IPipe<T> input;

    public AbstractReader(IPipe<T> input) {
        this.input = input;
    }

    @Override
    public void run() {
        generateInto(input);
    }

    public abstract void generateInto(IPipe<T> pipe);
}
