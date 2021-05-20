package art.tattoo.wowtattoo.controllers;


import art.tattoo.wowtattoo.dto.MasterDTO;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.service.MasterService;
import art.tattoo.wowtattoo.service.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class MasterPageController {

    @Autowired
    private MasterService masterService;

    @GetMapping("/status")
    public ResponseEntity checkServerStatus(){
        try{
            return  ResponseEntity.ok("Server работает");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер не работает");
        }
    }

    @GetMapping("/master/{id}")
    public MasterDTO getOneMaster(@PathVariable long id){
        MasterEntity masterEntity = new MasterEntity();
        try {
            masterEntity = masterService.getMaster(id);
            return MasterDTO.toMasterDTO(masterEntity);
//            return MasterDTO.toMasterDTO(masterService.getMaster(id));
        }  catch (Exception e){
            return MasterDTO.toMasterDTO(masterEntity);
        }
    }

}
