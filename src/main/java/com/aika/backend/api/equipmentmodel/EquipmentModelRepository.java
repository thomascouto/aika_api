package com.aika.backend.api.equipmentmodel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
    List<EquipmentModel> findAll();
}
