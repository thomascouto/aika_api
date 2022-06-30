package com.aika.backend.api.equipmentpositionhistory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/ep")
@RestController
public class EquipmentPositionHistoryController {

        @Autowired
        private EquipmentPositionHistoryRepository repository;

        @GetMapping(value = "/all")
        public ResponseEntity<List<EquipmentPositionHistory>> getAll() {
                try {
                        List<EquipmentPositionHistory> resultList = new ArrayList<EquipmentPositionHistory>();
                        repository.findAll().forEach(resultList::add);

                        if (resultList.isEmpty())
                                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                        return new ResponseEntity<List<EquipmentPositionHistory>>(resultList, HttpStatus.OK);
                } catch (Exception e) {
                        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }
}
