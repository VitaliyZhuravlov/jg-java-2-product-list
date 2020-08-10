package com.jg.productlist.validation;
import com.jg.productlist.domain.Product;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;

    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(Product product) {
        for (ProductValidationRule rule : validationRules) {
            rule.validate(product);
        }
    }
}
