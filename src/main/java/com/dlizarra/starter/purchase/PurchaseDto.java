package com.dlizarra.starter.purchase;

import com.dlizarra.starter.user.UserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ToString(of = {"id", "productName", "date", "price", "user"})
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PurchaseDto {
    private Integer id;

    @Size(max = Purchase.MAX_PRODUCT_NAME_LENGTH)
    private String product;

    private LocalDateTime date;

    private int price;

    private String user;

    @JsonIgnore
    private LocalDateTime creationTime;

    @JsonIgnore
    private LocalDateTime modificationTime;

    public PurchaseDto() {
    }
}
