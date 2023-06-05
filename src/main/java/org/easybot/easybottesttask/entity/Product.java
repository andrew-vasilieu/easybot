package org.easybot.easybottesttask.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION) @JsonSubTypes({

        @JsonSubTypes.Type(value = Desktop.class),
        @JsonSubTypes.Type(value = HardDrive.class),
        @JsonSubTypes.Type(value = Laptop.class),
        @JsonSubTypes.Type(value = Monitor.class)
})
@Data
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductType type;
    private String serialNo;
    private String manufacturer;
    private String price;
    private String quantity;
}
