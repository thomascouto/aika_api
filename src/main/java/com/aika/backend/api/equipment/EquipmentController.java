package com.aika.backend.api.equipment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aika.backend.api.base.BaseController;

@RequestMapping(value = "/eq")
@RestController
public class EquipmentController extends BaseController<Equipment, EquipmentRepository> {

}
