package InstagramProject.InstagramProject1.Controller;


import InstagramProject.InstagramProject1.MODEL.Cart;
import InstagramProject.InstagramProject1.SERVICE.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/addToCart/{id}")
    public String addProductToCart(@PathVariable int id){
        cartService.addToCart(id);
        return "redirect:/product/display";
    }
    @GetMapping("/displayCart")
    public String displayCartProduct(Model model){
        List<Cart> cartList=cartService.getAllCartProduct();
        model.addAttribute("cartList",cartList);
        return "displayCart";
    }
    @GetMapping("/remove/{id}")
    public String removeSingleItem(@PathVariable int id) {
        cartService.removeSingleItem(id);
        return "redirect:/cart/displayCart";
    }
    @GetMapping("/addMore/{id}")
    public String addMoreToCart(@PathVariable int id) {
        cartService.incrementCartItem(id);
        return "redirect:/cart/displayCart";
    }
}