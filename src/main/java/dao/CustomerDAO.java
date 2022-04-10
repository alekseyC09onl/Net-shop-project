package dao;

import java.util.List;

public interface CustomerDAO<C, K> {

    C addCustomer(C customer);

    C findCustomerById(K id);

    List<C> getCustomerList();

    void delCustomerById(K id);

    C updateCustomersData(C customer);

}
