package InstagramProject.InstagramProject1.SERVICE;

import InstagramProject.InstagramProject1.MODEL.Cart;
import InstagramProject.InstagramProject1.MODEL.Product;
import InstagramProject.InstagramProject1.REPOSETORY.CartRepository;
import InstagramProject.InstagramProject1.REPOSETORY.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public void addToCart(int id){
        Product p=productRepository.getSingleProduct(id);
        Cart temp=cartRepository.getSingleCartProduct(p.getProductId());
        if (temp==null){
            Cart c1=new Cart();
            c1.setProductId(p.getProductId());
            c1.setProductName(p.getProductName());
            c1.setCartQty(p.getProductId());
            c1.setProductPrice(p.getProductPrice());
            c1.setDiscountPrice(p.getDiscountedPrice());
            c1.setCartQty(1);
            cartRepository.save(c1);
        }else {
            int count= temp.getCartQty();
            temp.setCartQty(++count);
            cartRepository.save(temp);
        }
    }
    public List<Cart> getAllCartProduct(){
        return cartRepository.findAll();
    }
    public void removeSingleItem(int id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart!=null){
            if (cart.getCartQty() > 1) {
                cart.setCartQty(cart.getCartQty() - 1);
                cartRepository.save(cart);
            } else {
                cartRepository.deleteById(id);
            }
        }
    }
    public void incrementCartItem(int id) {
        Cart cartItem = cartRepository.findById(id).orElse(null);
        if (cartItem != null) {
            cartItem.setCartQty(cartItem.getCartQty() + 1);
            cartRepository.save(cartItem);
        }
    }
}