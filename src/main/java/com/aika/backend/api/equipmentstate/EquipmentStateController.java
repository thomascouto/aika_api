package com.aika.backend.api.equipmentstate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aika.backend.api.base.BaseController;

@RequestMapping(value = "/es")
@RestController
public class EquipmentStateController extends
        BaseController<EquipmentState, EquipmentStateRepository> {

}
