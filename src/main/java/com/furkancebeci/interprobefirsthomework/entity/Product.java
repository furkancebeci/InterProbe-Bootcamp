package com.furkancebeci.interprobefirsthomework.entity;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="PRODUCT")
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productComments"})
public class Product {

    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<ProductComment> productComments = new HashSet<>();
}
