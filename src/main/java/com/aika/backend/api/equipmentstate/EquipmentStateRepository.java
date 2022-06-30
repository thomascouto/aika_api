package com.aika.backend.api.equipmentstate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentStateRepository extends
        JpaRepository<EquipmentState, UUID> {

}
