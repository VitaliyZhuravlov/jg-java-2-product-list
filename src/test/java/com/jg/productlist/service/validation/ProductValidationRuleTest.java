package com.jg.productlist.service.validation;
import com.jg.productlist.validation.ProductValidationRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationRuleTest {
    @Spy
    private ProductValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenProductIsNull() {
        assertThatThrownBy(() -> victim.checkNotNull(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Product must be not null");
    }
}