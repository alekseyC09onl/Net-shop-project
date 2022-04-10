package dao;

import entity.Product;
import org.hibernate.Session;
import java.util.List;

import static utils.HibernateUtil.*;


public class ProductDAOImpl implements ProductDAO <Long, Product> {
    @Override
    public Product addProduct(Product product) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(product);

            session.getTransaction().commit();
            return product;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method addProduct - ProductDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProductList() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("from Product").list();
            session.getTransaction().commit();
            return productList;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method getProductList - ProductDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product updateProductData(Product product) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();


            session.update(product);

            session.getTransaction().commit();
            return product;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method updateProduct - ProductDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delProduct(Product product) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.delete(product);

            session.getTransaction().commit();
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method delProduct - ProductDAOImpl (o_o)");
            e.printStackTrace();
        }
    }
}
