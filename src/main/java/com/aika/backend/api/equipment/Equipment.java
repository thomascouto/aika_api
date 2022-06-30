package com.aika.backend.api.equipment;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.aika.backend.api.base.BaseClass;
import com.aika.backend.api.equipmentmodel.EquipmentModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Equipment extends BaseClass {

    @ManyToOne
    private EquipmentModel equipmentModel;
    private String name;
}
