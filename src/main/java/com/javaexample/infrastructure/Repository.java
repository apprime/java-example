package com.javaexample.infrastructure;

import java.util.Collection;

public interface Repository<T> {
    T Create(T item);
    //T Read(int id);
    Collection<T> Read();
    //T Update(T item);
    //void Delete(T item);
}
