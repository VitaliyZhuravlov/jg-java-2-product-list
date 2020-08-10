package com.jg.productlist.validation;
import com.jg.productlist.domain.Product;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
            if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
                throw new NumberFormatException(ValidationExceptionMessages.PRICE_VALIDATION_MSG);
            }
    }
}
