package service;

import java.math.BigDecimal;

public interface GenericService<T>{
    // a method to save and update :
        void Check(T ch);
    // a method for cancelling and removing:
        void remove(BigDecimal id);
        void cancelling(BigDecimal id);

}
