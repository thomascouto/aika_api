package com.aika.backend.api.equipmentmodel;

import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aika.backend.api.base.BaseController;

@RequestMapping(value = "/em")
@RestController
public class EquipmentModelController
        extends BaseController<EquipmentModel, EquipmentModelRepository> {

    @Override
    public ResponseEntity<EquipmentModel> updateEntity(@PathVariable("id") UUID id,
            @RequestBody EquipmentModel updateEm) {

        try {
            Optional<EquipmentModel> em = repository.findById(id);
            if (em.isPresent()) {
                EquipmentModel currentEm = em.get();
                currentEm.setName(updateEm.getName());
                return new ResponseEntity<EquipmentModel>(repository.save(currentEm),
                        HttpStatus.OK);
            }
            return new ResponseEntity<EquipmentModel>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
