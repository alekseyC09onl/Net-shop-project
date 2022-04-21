package fortests;

import entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class HibernateRunnerDemo {
    public static void main(String[] args) {
//        Configuration configuration = new Configuration();
//            configuration.configure("hibernate.cfg.xml");
//            configuration.addAnnotatedClass(Customer.class);
//            configuration.addAnnotatedClass(Product.class);
        Role admin = Role.builder()
                .roleTitle("admin")
                .build();

        Role user = Role.builder()
                .roleTitle("user")
                .build();



        User alex = User.builder()
                .email("alex@gmail.com")
                .password("alex")
                .phoneNumber("31234567")
                .firstName("aleksey")
                .role(user)
                .build();

        User roy = User.builder()
                .email("roy@mail.ru")
                .password("roy")
                .firstName("roy")
                .phoneNumber("123463")
                .role(user)
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

        List<Product> productList1 = List.of(milk, sugar);
        List<Product> productList2 = List.of(banana);

        Order order1 = Order.builder()
                .orderNumber("100")
                .productList(productList2)
                .build();


        Order order2 = Order.builder()
                .orderNumber("101")
                .productList(productList2)
                .build();


        Address address1 = Address.builder()
                .city("Minsk")
                .street("Nezavisimosti")
                .houseNumber("14k5")
                .level(2)
                .flatNumber("112b")
                .build();

        Address address2 = Address.builder()
                .city("Minsk")
                .street("Lenina")
                .houseNumber("8")
                .level(5)
                .flatNumber("59")
                .build();



        List<Order> orderList1 = List.of(order1);
        List<Order> orderList2 = List.of(order2);
        List<Address> addressList1 = List.of(address1);
        List<Address> addressList2 = List.of(address2);


        Customer customerAlex = Customer.builder()
                .email("alex@gmail.com")
                .firstName("alex")
                .lastName("kross")
                .phoneNumber("+37291324658")
                .orderList(orderList1)
                .addressList(addressList1)
                .build();

        Customer customerRoy = Customer.builder()
                .email("roy@gmail.com")
                .firstName("roy")
                .lastName("palmer")
                .phoneNumber("+37291324658")
                .orderList(orderList2)
                .addressList(addressList2)
                .build();




        try {
            Session session = utils.HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
//            session.saveOrUpdate(admin);
//            session.saveOrUpdate(user);
//
//            session.saveOrUpdate(alex);
//            session.saveOrUpdate(roy);
//
//
//            session.save(banana);
//            session.save(sugar);
//            session.save(milk);
//
//            session.save(order1);
//            session.save(order2);
//
            session.save(address1);
            session.save(address2);
//
//            session.save(customerAlex);
//            session.save(customerRoy);
//

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }


    }

}
