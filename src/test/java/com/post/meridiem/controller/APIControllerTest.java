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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class APIControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private APIController apiController;

    @Test
    public void testGetProducts() {
        // Given
        boolean value = true;
        List<Products> products = new ArrayList<>();
        when(productService.getProducts(value)).thenReturn(products);

        // When
        List<Products> result = apiController.getProducts(value);

        // Then
        assertEquals(products, result);
    }

    @Test
    public void testGetProducts_EmptyList() {
        // Given
        boolean value = false;
        List<Products> products = new ArrayList<>();
        when(productService.getProducts(value)).thenReturn(products);

        // When
        List<Products> result = apiController.getProducts(value);

        // Then
        assertEquals(products, result);
    }
}