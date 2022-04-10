package entity;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers", schema = "shop_schema")
@Component //for test with spring
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(name = "customers_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(name, customer.name) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(dateOfBirth, customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, phoneNumber, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", productList=" + productList +
                '}';
    }
}

