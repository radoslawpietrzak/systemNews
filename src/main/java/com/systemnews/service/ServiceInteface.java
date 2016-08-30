package com.systemnews.service;
import java.util.List;
/**
 * Created by RADEK on 2016-08-30.
 */
public interface ServiceInteface<T> {

    List<T> getObj(); //lista wszystkich obiektow danej klasy
    T create (T obj);
    T findbyId(String id);
    T update(T obj);
}
