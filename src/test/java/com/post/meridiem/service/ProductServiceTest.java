import com.post.meridiem.model.Products;
import com.post.meridiem.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void testGetProducts_WhenValueIsTrue_ReturnsListOfProducts() {
        // Given
        boolean value = true;
        int expectedSize = 2;

        // When
        List<Products> products = productService.getProducts(value);

        // Then
        assertNotNull(products);
        assertEquals(expectedSize, products.size());
        assertTrue(products.stream().anyMatch(p -> p.getProductId().equals("100")));
        assertTrue(products.stream().anyMatch(p -> p.getProductId().equals("101")));
    }

    @Test
    void testGetProducts_WhenValueIsFalse_ReturnsEmptyList() {
        // Given
        boolean value = false;
        int expectedSize = 0;

        // When
        List<Products> products = productService.getProducts(value);

        // Then
        assertNotNull(products);
        assertEquals(expectedSize, products.size());
    }

    @Test
    void testGetProducts_WhenValueIsNull_ThrowsNullPointerException() {
        // Given
        Boolean value = null;

        // When and Then
        assertThrows(NullPointerException.class, () -> productService.getProducts(value));
    }
}