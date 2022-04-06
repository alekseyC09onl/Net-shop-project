package entity;

import lombok.*;


import javax.persistence.*;
import java.util.Date;

import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admins", schema = "shop_schema")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

//    @OneToMany(mappedBy = "admins", fetch = FetchType.LAZY)
//    private List<Product> productList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) && Objects.equals(email, admin.email) && Objects.equals(password, admin.password) && Objects.equals(name, admin.name) && Objects.equals(phoneNumber, admin.phoneNumber) && Objects.equals(dateOfBirth, admin.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, phoneNumber, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", proneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
