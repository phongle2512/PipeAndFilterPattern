package com.kms.pipeandfilter.filter;

import com.kms.pipeandfilter.pipe.IPipe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SimpleFilter<I, O> extends Filter<I, O> {
    public SimpleFilter(IPipe<I> input, IPipe<O> output) {
        super(input, output);
    }

    @Override
    protected void doFilter(IPipe<I> input, IPipe<O> output) {
        try {
            I in;
            while ((in = input.nextOrNullIfEmptied()) != null) {
                O out = doFilter(in);
                output.put(out);
            }
        } catch (InterruptedException e) {
            log.error("Interrupted:", e.getMessage());
        }
        output.closeForWriting();
    }

    protected abstract O doFilter(I in);
}
