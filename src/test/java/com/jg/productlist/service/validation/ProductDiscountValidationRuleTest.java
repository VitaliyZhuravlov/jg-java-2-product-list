package com.jg.productlist.service.validation;
import com.jg.productlist.domain.Product;
import com.jg.productlist.validation.ProductDiscountValidationRule;
import com.jg.productlist.validation.ValidationExceptionMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountValidationRuleTest {
    @InjectMocks
    private ProductDiscountValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenExceedsDiscountLimit() {
        Product input = new Product();
        input.setDiscount(new BigDecimal(101));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ValidationExceptionMessages.DISCOUNT_VALIDATION_MSG);
    }

    @Test
    public void shouldThrowExceptionWhenDiscountIsNegative() {
        Product input = new Product();
        input.setDiscount(new BigDecimal(-1));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ValidationExceptionMessages.NEGATIVE_DISCOUNT_VALIDATION_MSG);
    }
}