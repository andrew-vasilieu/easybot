package org.easybot.easybottesttask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "monitor")
@Data
@RequiredArgsConstructor
public class Monitor extends Product{

    private String screenSize;
}
