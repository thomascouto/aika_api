package com.aika.backend.api.equipmentmodel;

// import java.util.Optional;
// import java.util.UUID;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aika.backend.api.base.BaseController;

@RequestMapping(value = "/em")
@RestController
public class EquipmentModelController
        extends BaseController<EquipmentModel, EquipmentModelRepository> {

}
