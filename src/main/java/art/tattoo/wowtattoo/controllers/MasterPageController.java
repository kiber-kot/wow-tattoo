package art.tattoo.wowtattoo.controllers;


import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.MasterMapper;
import art.tattoo.wowtattoo.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController()
@RequestMapping("/api")
public class MasterPageController {

    @Autowired
    private MasterService masterService;

    @Autowired
    private MasterMapper masterMapper;


    @GetMapping("/status")
    public ResponseEntity checkServerStatus(){
        try{
            return  ResponseEntity.ok("Server работает");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер не работает");
        }
    }

    @GetMapping("/master/{id}")
    public MasterDto getOneMaster(@PathVariable long id){
        MasterEntity masterEntity = new MasterEntity();
        try {
            masterEntity = masterService.getMaster(id);
            return masterMapper.toDto(masterEntity);
        }  catch (Exception e){
            return masterMapper.toDto(masterEntity);
        }
    }

}
