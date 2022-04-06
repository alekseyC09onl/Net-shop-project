package entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products", schema = "shop_schema")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nameProduct")
    private String nameProduct;

    @Column(name = "price")
    private Double price;

    @Column(name = "availableProduct")
    private boolean availableProduct;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "admin_id")
//    private Administr admin;


    @ManyToMany
    @JoinTable(name = "customers_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customerList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return availableProduct == product.availableProduct && Objects.equals(id, product.id) && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, price, availableProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", availableProduct=" + availableProduct +
                '}';
    }
}