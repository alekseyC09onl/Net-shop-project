package fortests;

import dao.AdminDAOImpl;
import dao.ProductDAOImpl;
import mappers.AdminMapper;

public class MainTest {
    public static void main(String[] args) {

        ProductDAOImpl productDAO = new ProductDAOImpl();
        AdminDAOImpl adminDAO = new AdminDAOImpl();
//        Product newBread = productDAO.getProductList().stream().filter(product -> product.getNameProduct().equals("bread")).collect(Collectors.toList()).get(0);
//        productDAO.delProduct(newBread);
//        productDAO.updateProductData(newBread);
//        Product bread = Product.builder()
//                .nameProduct("bread")
//                .price(1.2)
//                .availableProduct(true)
//                .build();
//        productDAO.addProduct(bread);
//        productDAO.updateProductData(newBread);
//        System.out.println(productDAO.findProductByNameProduct("bread").getPrice());

        System.out.println(AdminMapper.mapAdminToAdminDTO(adminDAO.findAdminById(1)));




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



