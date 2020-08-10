package com.jg.productlist.validation;
import com.jg.productlist.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);

    default void checkNotNull(Product product){
        if(product == null){
            throw new IllegalArgumentException("Product must be not null");
        }
    }
}
