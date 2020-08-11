package com.jg.productlist.service.validation;
import com.jg.productlist.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductCategoryValidationRuleTest {
    @Spy
    @InjectMocks
    private ProductCategoryValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenCategoryDoesNotExist() {
        Product input = new Product();
        input.setCategory("YOGURT");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
        verify(victim).checkNotNull(input);
    }
}