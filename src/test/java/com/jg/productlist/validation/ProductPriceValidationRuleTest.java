package com.jg.productlist.validation;
import com.jg.productlist.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceValidationRuleTest {
    @InjectMocks
    private ProductPriceValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenPriceIsNegative() {
        Product input = new Product();
        input.setPrice(new BigDecimal(-1));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ValidationExceptionMessages.PRICE_VALIDATION_MSG);
    }
}