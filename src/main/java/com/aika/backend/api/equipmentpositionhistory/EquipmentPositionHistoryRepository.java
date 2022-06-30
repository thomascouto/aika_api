package com.aika.backend.api.equipmentpositionhistory;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentPositionHistoryRepository extends
        JpaRepository<EquipmentPositionHistory, UUID> {

}
