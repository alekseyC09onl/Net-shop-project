package dao;

import entity.Admin;
import entity.Customer;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

import static utils.HibernateUtil.getSessionFactory;

public class AdminDAOImpl implements AdminDAO<Integer, Admin> {

    @Override
    public Admin addAdmin(Admin admin) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(admin);

            session.getTransaction().commit();
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method addAdmin - AdminDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin findAdminById(Integer id) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            Admin admin = session.find(Admin.class, id);

            session.getTransaction().commit();
            return admin;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method findAdminById - AdminDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> getAdminList() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            List<Admin> adminList = session.createQuery("from Admin ").list();

            session.getTransaction().commit();
            return adminList;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method getAdminList - AdminDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin updateAdminData(Admin admin) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.update(admin);

            session.getTransaction().commit();
            return admin;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method updateAdminData - AdminDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delAdminById(Admin admin) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.delete(admin);

            session.getTransaction().commit();
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method delAdminById - AdminDAOImpl (o_o)");
            e.printStackTrace();
        }
    }

    @Override
    public Admin findAdminByEmail(String email) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Admin> adminList = session.createQuery("from Admin ").list();
            session.getTransaction().commit();
            Admin foundAdmin = adminList.stream()
                    .filter(admin -> admin.getEmail().equals(email))
                    .collect(Collectors.toList())
                    .get(0);
            return foundAdmin;
        } catch (Throwable e) {
            System.out.println("(o_o) Error in method findAdminByEmail - AdminDAOImpl (o_o)");
            e.printStackTrace();
        }
        return null;
    }
}
