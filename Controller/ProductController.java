package InstagramProject.InstagramProject1.Controller;

import InstagramProject.InstagramProject1.MODEL.Product;
import InstagramProject.InstagramProject1.SERVICE.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    private List<Product> productList;
    @GetMapping("/display")
    public String displayProduct(Model model){
        productList=service.displayAllProduct();
        model.addAttribute("productList",productList);
        return "displayProduct";
    }
}