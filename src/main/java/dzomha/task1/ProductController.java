package dzomha.task1;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

//    @Autowired
//    public ProductController(ProductService service) {
//        this.productService = service;
//    }


    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {

        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id,@RequestBody ProductDTO product) {
    try{
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }
    catch(Exception e){
        return ResponseEntity.notFound().build();
    }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        try {
            productService.deleteProduct(id);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}