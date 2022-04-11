package dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDTO {
    private String email;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO adminDTO = (AdminDTO) o;
        return Objects.equals(email, adminDTO.email) && Objects.equals(name, adminDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name);
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
