package service;

import model.Event;

import java.math.BigDecimal;

public interface GenericService<T> {
    // a method to save and update :
    int checkForSaveAndUpdate(T ch);

    //to control delete methods :
    int checkForDelete(T ch);

    //a method to control fin by id :
    int checkForFindById(T ch);

    // a method to check for find all :
    int checkForFindAll(T ch);

}