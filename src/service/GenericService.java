package service;

import model.Event;

import java.math.BigDecimal;

public interface GenericService<T> {
    // a method to save and update :
    void checkForSaveAndUpdate(T ch);

    //to control delete methods :
    void checkForDelete(T ch);

    //a method to control fin by id :
    void checkForFindById(T ch);

    // a method to check for find all :
    void checkForFindAll(T ch);

}