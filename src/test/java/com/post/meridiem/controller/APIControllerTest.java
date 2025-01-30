import com.post.meridiem.controller.APIController;
import com.post.meridiem.model.Products;
import com.post.meridiem.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class APIControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private APIController apiController;

    @Test
    void testGetProducts() {
        // Given
        boolean value = true;
        List<Products> products = new ArrayList<>();
        when(productService.getProducts(anyBoolean())).thenReturn(products);

        // When
        List<Products> result = apiController.getProducts(value);

        // Then
        assertNotNull(result);
        assertEquals(products, result);
    }

    @Test
    void testGetProducts_ServiceReturnsNull() {
        // Given
        boolean value = true;
        when(productService.getProducts(anyBoolean())).thenReturn(null);

        // When
        List<Products> result = apiController.getProducts(value);

        // Then
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}