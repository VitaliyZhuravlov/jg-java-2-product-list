package com.jg.productlist.service.validation;
import com.jg.productlist.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductDescriptionValidationRuleTest {

    @Spy
    @InjectMocks
    private ProductDescriptionValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenDescriptionToShort() {
        Product input = new Product();
        input.setDescription("Banani no");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage(ValidationExceptionMessages.DESCRIPTION_VALIDATION_MSG);
    }
}