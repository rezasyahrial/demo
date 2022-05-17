package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PrimaryKey implements Serializable {

    @Column(name = "product_id")
    long productId;

    @Column(name = "cart_id")
    long cartId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrimaryKey)) return false;
        PrimaryKey that = (PrimaryKey) o;
        return getProductId() == that.getProductId() && getCartId() == that.getCartId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getCartId());
    }
}
