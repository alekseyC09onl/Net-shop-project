package dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String nameProduct;
    private Double price;
    private Boolean availableProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(nameProduct, that.nameProduct) && Objects.equals(price, that.price) && Objects.equals(availableProduct, that.availableProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price, availableProduct);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", availableProduct=" + availableProduct +
                '}';
    }
}
