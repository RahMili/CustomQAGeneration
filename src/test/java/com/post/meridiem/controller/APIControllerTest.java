// Modified APIController.java
@GetMapping("/products")
public List<Products> getProducts(@RequestParam boolean value){
    return productService.getProducts(value);
}