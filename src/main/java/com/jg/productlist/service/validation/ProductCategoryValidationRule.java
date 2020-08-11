package com.jg.productlist.service.validation;
import com.jg.productlist.domain.Category;
import com.jg.productlist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        Category categoryValue = Category.valueOf(product.getCategory());
        if(categoryValue == null){
            throw new IllegalArgumentException("No such category");
        }
    }
}
