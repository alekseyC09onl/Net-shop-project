package dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private String email;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
