package fortests;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import entity.Product;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {

        ProductDAOImpl productDAO = new ProductDAOImpl();

//        Product newBread = productDAO.getProductList().stream().filter(product -> product.getNameProduct().equals("bread")).collect(Collectors.toList()).get(0);
//        productDAO.delProduct(newBread);
//        productDAO.updateProductData(newBread);
        Product bread = Product.builder()
                .nameProduct("bread")
                .price(1.2)
                .availableProduct(true)
                .build();
        productDAO.addProduct(bread);
//        productDAO.updateProductData(newBread);





//        List<Product> productList = productDAO.getProductList();

//        Product salt = Product.builder()
//                .nameProduct("salt")
//                .price(1.1)
//                .availableProduct(true)
//
//                .build();
//
//        productDAO.addProduct(salt);

    }
}



