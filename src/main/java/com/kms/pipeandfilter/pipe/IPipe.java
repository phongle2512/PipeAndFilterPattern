package com.kms.pipeandfilter.pipe;

public interface IPipe<T> {
    public boolean put(T obj);
    public T nextOrNullIfEmptied() throws InterruptedException;
    public void closeForWriting();
}
