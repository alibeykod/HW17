package service;

import model.Event;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface GenericService<T> {
    // a method to save:
    void checkForSave(T ch);

    // a method to save:
    void checkForUpdate(T ch);


    //to control delete methods :
    void checkForDelete(BigInteger id);

    //a method to control fin by id :
    T checkForFindById(BigInteger id);

    // a method to check for find all :
    List<T> checkForFindAll(T ch);

}