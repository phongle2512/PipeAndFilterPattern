package com.kms.pipeandfilter;

import com.kms.pipeandfilter.filter.ConvertFilter;
import com.kms.pipeandfilter.filter.Filter;
import com.kms.pipeandfilter.filter.Rot13Filter;
import com.kms.pipeandfilter.pipe.IPipe;
import com.kms.pipeandfilter.pipe.Pipe;
import com.kms.pipeandfilter.sink.SinkWriter;
import com.kms.pipeandfilter.source.NumberReader;
import com.kms.pipeandfilter.source.AbstractReader;
import com.kms.pipeandfilter.sink.AbstractWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PipeAndFilterRunner {

    public static void main(String[] args) {
        // create pipes
        final IPipe<Integer> sourceToFilter = new Pipe<>();
        final IPipe<String> convertToOut = new Pipe<>();
        final IPipe<String> rotFilterToOut = new Pipe<>();

        // create components that use the pipes
        final AbstractReader<Integer> source = new NumberReader(sourceToFilter);
        final Filter<Integer, String> convertFilter = new ConvertFilter(sourceToFilter, convertToOut);
        final Filter<String, String> rot13Filter = new Rot13Filter(convertToOut, rotFilterToOut);
        final AbstractWriter<String> sink = new SinkWriter(rotFilterToOut);

        // start all components
        log.info("Start pipe and filter");
        source.start();
        convertFilter.start();
        rot13Filter.start();
        sink.start();
    }
}
