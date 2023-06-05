package org.easybot.easybottesttask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.easybot.easybottesttask.validation.OneOf;

@Entity
@Table(name = "Laptop")
@Data
@RequiredArgsConstructor
public class Laptop extends Product{
    @OneOf({13, 14, 15, 17})
    private int size;
}
