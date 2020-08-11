package com.jg.productlist.service.validation;
import com.jg.productlist.domain.Product;
import com.jg.productlist.validation.ProductNameValidationRule;
import com.jg.productlist.validation.ValidationExceptionMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameValidationRuleTest {
    @Spy
    @InjectMocks
    private ProductNameValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenNameTooShort() {
        Product input = new Product();
        input.setName("Ki");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationExceptionMessages.SHORT_NAME_VALIDATION_MSG);
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldThrowExceptionWhenNameTooLong() {
        Product input = new Product();
        input.setName("Potato Tomato Banana Lemon Apple");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationExceptionMessages.LONG_NAME_VALIDATION_MSG);
        verify(victim).checkNotNull(input);
    }
}