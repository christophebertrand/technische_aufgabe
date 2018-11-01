package com.dlizarra.starter.purchase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString(of = {"id", "product", "user", "price", "date"})
@Setter
@Getter
@Entity
@Table(name = "purchases")
public class Purchase {

    static final int MAX_PRODUCT_NAME_LENGTH = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = MAX_PRODUCT_NAME_LENGTH)
    private String product;

    //@Column(nullable = false)
    // I removed the constraint that the date cannot be null firstly to make it easier to test.
    // And I got some mapping errors when I tried to use a date. (This is also the reason I added an
    // @JsonIgnore to the creationTime and modificationTime in PurchaseDto.
    private LocalDateTime date;

    @Column(nullable = false)
    private int price;

    // I tried to use the User class instead of a string but I got some runtime errors with
    // the nested User class when the mapper tried to map from User to UserDto.
    //@JoinColumn(name = "user_id", nullable = false)
    //@ManyToOne(fetch = FetchType.LAZY)
    private String user;

    private LocalDateTime creationTime;

    private LocalDateTime modificationTime;

    public Purchase() {
    }

    @PrePersist
    public void prePersist() {
        creationTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = LocalDateTime.now();
    }
}
