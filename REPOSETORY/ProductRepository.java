package InstagramProject.InstagramProject1.REPOSETORY;


import InstagramProject.InstagramProject1.MODEL.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
  @Query(value = "select * from product",nativeQuery = true)
  public List<Product> getAllProducts();
  @Query(value = "select * from product where product_id=:id",nativeQuery = true)
  public Product getSingleProduct(@Param("id") int id);

}