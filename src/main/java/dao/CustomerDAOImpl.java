package dao;

import entity.Customer;
import entity.Product;
import org.hibernate.Session;

import java.util.List;

import static utils.HibernateUtil.*;

public class CustomerDAOImpl implements CustomerDAO<Customer, Integer> {
    @Override
    public Customer addCustomer(Customer customer) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(customer);

            session.getTransaction().commit();
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method addCustomer - CustomerDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        Customer customer;
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            customer = session.find(Customer.class, id);

            session.getTransaction().commit();
            return customer;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method findCustomerById - CustomerDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomerList() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            List<Customer> customerList = session.createQuery("from Customer ").list();

            session.getTransaction().commit();
            return customerList;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method getCustomerList - CustomerDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delCustomerById(Customer customer) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.delete(customer);

            session.getTransaction().commit();
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method delCustomerById - CustomerDAOImpl (o_o)");
            e.printStackTrace();
        }
    }

    @Override
    public Customer updateCustomersData(Customer customer) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.update(customer);

            session.getTransaction().commit();
            return customer;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method updateCustomersData - CustomerDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }
}

