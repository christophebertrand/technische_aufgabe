package com.dlizarra.starter.purchase;

import com.dlizarra.starter.user.User;
import com.dlizarra.starter.user.UserDto;
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
    private LocalDateTime date;

    @Column(nullable = false)
    private int price;

    //TODO find problem
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
