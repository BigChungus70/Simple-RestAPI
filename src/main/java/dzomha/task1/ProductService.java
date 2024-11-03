package dzomha.task1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts() {

        return productRepository.findAll();
    }
    public Product getProduct(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product doesn't exist :("));
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public Product updateProduct(int id,ProductDTO product) {
        Product savedProduct =
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product doesn't exist :("));
        if(product.getName()!=null) {
            savedProduct.setName(savedProduct.getName());
        }
        if(product.getDescription()!=null) {
            savedProduct.setDescription(product.getDescription());
        }
        if(product.getPrice()!=0) {
            savedProduct.setPrice(product.getPrice());
        }
        return productRepository.save(savedProduct);
    }
    public void deleteProduct(int id) {
        Optional<Product> p = productRepository.findById(id);
        if (p.isPresent()){
            productRepository.deleteById(id);
            return ;
        }
        else
            throw new RuntimeException("Product doesn't exist :(");
    }

}
