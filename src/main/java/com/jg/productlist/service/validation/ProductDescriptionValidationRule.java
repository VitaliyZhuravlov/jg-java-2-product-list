package com.jg.productlist.service.validation;
import com.jg.productlist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getDescription().length() < 10) {
            throw new ProductValidationException(ValidationExceptionMessages.DESCRIPTION_VALIDATION_MSG);
            }
    }
}
