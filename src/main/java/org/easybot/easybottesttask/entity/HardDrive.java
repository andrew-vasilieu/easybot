package org.easybot.easybottesttask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "hard_drive")
@Data
@RequiredArgsConstructor
public class HardDrive extends Product{

    private String capacityGb;
}
