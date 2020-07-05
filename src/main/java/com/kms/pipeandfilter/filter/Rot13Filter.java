package com.kms.pipeandfilter.filter;

import com.kms.pipeandfilter.pipe.IPipe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rot13Filter extends SimpleFilter<String, String> {
    public Rot13Filter(IPipe<String> input, IPipe<String> output) {
        super(input, output);
    }

    @Override
    protected String doFilter(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(rot13(input.charAt(i)));
        }
        log.info("Rot13 filter from {} to {}", input, sb.toString());
        delayForDebug(100);
        return sb.toString();
    }

    /**
     * Encodes the string using Rot13. Rot13 works by replacing each upper
     *  and lower case letters with the letter 13 positions ahead or behind
     *  it in the alphabet. The encryption algorithm is symmetric - applying
     *  the same algorithm a second time recovers the original message.
     * @param input
     * @return
     */
    private char rot13 (char input) {
        char c = input;
        if       (c >= 'a' && c <= 'm') c += 13;
        else if  (c >= 'A' && c <= 'M') c += 13;
        else if  (c >= 'n' && c <= 'z') c -= 13;
        else if  (c >= 'N' && c <= 'Z') c -= 13;
        return c;
    }
}
