package com.kms.pipeandfilter.filter;

import com.kms.pipeandfilter.pipe.IPipe;
import com.kms.pipeandfilter.ThreadedRunner;

public abstract class Filter<I, O> extends ThreadedRunner {
    protected IPipe<I> input;
    protected IPipe<O> output;

    public Filter(IPipe<I> input, IPipe<O> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        doFilter(input, output);
    }

    protected abstract void doFilter(IPipe<I> input, IPipe<O> output);

}
