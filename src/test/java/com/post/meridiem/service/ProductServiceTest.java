import com.post.meridiem.model.Products;
import com.post.meridiem.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void testGetProducts_WhenValueIsTrue_ThenReturnProducts() {
        // Given
        boolean value = true;

        // When
        List<Products> products = productService.getProducts(value);

        // Then
        assertNotNull(products);
        assertEquals(2, products.size());
        assertEquals("100", products.get(0).getProductId());
        assertEquals("Sample Product", products.get(0).getProductName());
        assertEquals(100D, products.get(0).getProductPrice());
        assertEquals("101", products.get(1).getProductId());
        assertEquals("Trial Product", products.get(1).getProductName());
        assertEquals(100D, products.get(1).getProductPrice());
    }

    @Test
    void testGetProducts_WhenValueIsFalse_ThenReturnEmptyList() {
        // Given
        boolean value = false;

        // When
        List<Products> products = productService.getProducts(value);

        // Then
        assertNotNull(products);
        assertTrue(products.isEmpty());
    }
}