package dao;

import java.util.List;

public interface AdminDAO <K, A>{

    A addAdmin(A admin);

    A findAdminById(K id);

    List<A> getAdminList();

    void delAdminById(K id);

}
