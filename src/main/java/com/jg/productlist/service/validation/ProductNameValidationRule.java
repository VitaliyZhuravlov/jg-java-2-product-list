package com.jg.productlist.service.validation;
import com.jg.productlist.domain.Product;
import com.jg.productlist.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    private final ProductRepository repository;

    public ProductNameValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < 3) {
            throw new IllegalArgumentException(ValidationExceptionMessages.SHORT_NAME_VALIDATION_MSG);
        }
        if (product.getName().length() >= 32) {
            throw new IllegalArgumentException(ValidationExceptionMessages.LONG_NAME_VALIDATION_MSG);
        }
        }
    }
