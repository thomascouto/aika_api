package com.aika.backend.api.equipmentmodel;

import javax.persistence.Entity;
import com.aika.backend.api.base.BaseClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class EquipmentModel extends BaseClass {
    private String name;
}
