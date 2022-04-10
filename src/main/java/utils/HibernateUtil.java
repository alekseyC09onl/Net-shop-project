package utils;

import entity.Admin;
import entity.Customer;
import entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;


    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(Admin.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println("(o_o) Error to create SessionFactory (o_o)");
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
