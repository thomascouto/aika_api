package com.aika.backend.api.equipmentpositionhistory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aika.backend.api.equipment.Equipment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class EquipmentPositionHistory {

    private Date date;
    private Long lat;
    private Long lon;

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;
}
