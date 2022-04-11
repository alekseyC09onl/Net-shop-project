package dao;

import java.util.List;

public interface CustomerDAO<C, K> {

    C addCustomer(C customer);

    C findCustomerById(K id);

    List<C> getCustomerList();

    void delCustomerById(C customer);

    C updateCustomersData(C customer);

    C findCustomerByEmail(String email);

}
