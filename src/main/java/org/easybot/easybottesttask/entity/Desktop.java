package org.easybot.easybottesttask.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "desktop")
@Data
@RequiredArgsConstructor
public class Desktop extends Product{
    @Enumerated(EnumType.STRING)
    private DesktopType desktopType;
}
