package com.aika.backend.api.equipmentstate;

import javax.persistence.Entity;

import com.aika.backend.api.base.BaseClass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class EquipmentState extends BaseClass {

    private String name;
    private String color;
}
