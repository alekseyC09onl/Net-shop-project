import entity.Customer;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Date;

public class HibernateRunnerDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Product.class);

        Customer alex = Customer.builder()
                .email("alex@gmail.com")
                .password("alex")
                .phoneNumber(1234567)
                .name("aleksey")
                .dateOfBirth(LocalDate.of(1997, 12,12))
                .build();

        Customer roy = Customer.builder()
                .email("roy@mail.ru")
                .password("roy")
                .name("roy")
                .phoneNumber(123463)
                .dateOfBirth(LocalDate.of(1999, 4,4))
                .build();

        Product banana = Product.builder()
                .nameProduct("banana")
                .price(5.0)
                .availableProduct(true)
                .build();

        Product milk = Product.builder()
                .nameProduct("milk")
                .price(1.5)
                .availableProduct(true)
                .build();

        Product sugar = Product.builder()
                .nameProduct("sugar")
                .price(1.7)
                .availableProduct(true)
                .build();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            session.beginTransaction();
//            session.save(alex);
//            session.save(roy);
//            session.save(banana);
//            session.save(sugar);
//            session.save(milk);
            System.out.println("-=-=-=-=-==-==-===-=-=-=-=-=-");

            session.getTransaction().commit();
        }
    }

}
