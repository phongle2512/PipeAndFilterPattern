package com.kms.pipeandfilter.sink;

import com.kms.pipeandfilter.pipe.IPipe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SinkWriter extends AbstractWriter<String> {

    public SinkWriter(IPipe<String> output) {
        super(output);
    }

    @Override
    public void takeFrom(IPipe<String> pipe) {
        try {
            String out;
            while ((out = pipe.nextOrNullIfEmptied()) != null) {
                log.info("Print output: {}", out);
                delayForDebug(300);
            }
            log.info("Sink finished");
        } catch (InterruptedException e) {
            log.error("Interrupted:", e.getMessage());
        }
    }
}
