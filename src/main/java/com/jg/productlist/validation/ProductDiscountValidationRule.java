package com.jg.productlist.validation;
import com.jg.productlist.domain.Product;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDiscount().compareTo(BigDecimal.ZERO) > 100) {
            throw new NumberFormatException(ValidationExceptionMessages.DISCOUNT_VALIDATION_MSG);
    }
        if (product.getDiscount().compareTo(BigDecimal.ZERO) < 0){
            throw new NumberFormatException(ValidationExceptionMessages.NEGATIVE_DISCOUNT_VALIDATION_MSG);
        }
    }
}
