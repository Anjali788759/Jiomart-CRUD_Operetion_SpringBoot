package InstagramProject.InstagramProject1.SERVICE;

import InstagramProject.InstagramProject1.MODEL.Product;
import InstagramProject.InstagramProject1.REPOSETORY.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> displayAllProduct(){
        return productRepository.findAll();
    }
}