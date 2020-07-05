package com.kms.pipeandfilter.sink;

import com.kms.pipeandfilter.pipe.IPipe;
import com.kms.pipeandfilter.ThreadedRunner;

public abstract class AbstractWriter<T> extends ThreadedRunner {

    protected IPipe<T> output;

    public AbstractWriter(IPipe<T> output) {
        this.output = output;
    }

    @Override
    public void run() {
        takeFrom(output);
    }

    public abstract void takeFrom(IPipe<T> pipe);
}
