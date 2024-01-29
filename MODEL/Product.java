package InstagramProject.InstagramProject1.MODEL;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "discounted_price")
    private double discountedPrice;

    @Column(name = "product_cat")
    private String productCat;

    @Column(name = "product_subcat")
    private String productSubCat;

    @Column(name = "product_qty")
    private String productQty;

}