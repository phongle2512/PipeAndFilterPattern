package com.kms.pipeandfilter.filter;

import com.kms.pipeandfilter.pipe.IPipe;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.Charset;
import java.util.Random;

@Slf4j
public class ConvertFilter extends SimpleFilter<Integer, String> {
    public ConvertFilter(IPipe<Integer> input, IPipe<String> output) {
        super(input, output);
    }

    @Override
    protected String doFilter(Integer in) {
        String out = RandomStringUtils.random(in.intValue(), true, false);
        log.info("Generate a random string with length {} : {}", in, out);
        delayForDebug(100);
        return out;
    }
}
