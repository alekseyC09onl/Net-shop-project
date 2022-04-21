package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address", schema = "shop_schema")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 4416758421267762740L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "houseNumber")
    private String houseNumber;

    @Column(name = "flatNumber")
    private String flatNumber;

    @Column(name = "level")
    private Integer level;

    //    @ManyToOne
//    @JoinColumn(name = "customerId")
//    private Customer customer;
//
    @ManyToOne
    @JoinTable(name = "customers", schema = "shop_schema",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "addressId")})
    private Customer customer;
}
