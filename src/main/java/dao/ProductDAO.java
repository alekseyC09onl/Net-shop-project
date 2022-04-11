package dao;

import java.util.List;

public interface ProductDAO <K, P> {

    P addProduct(P product);

    List<P> getProductList();

    P updateProductData(P product);

    void delProduct(P product);

    P findProductByNameProduct(String nameProduct);

}
