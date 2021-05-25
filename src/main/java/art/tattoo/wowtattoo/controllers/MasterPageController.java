package art.tattoo.wowtattoo.controllers;


import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
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
        MasterDto masterDto = new MasterDto();
        try {
            masterDto = masterService.getMaster(id);
            return masterDto;
        }  catch (Exception e){
            return masterDto;
        }
    }

    @PostMapping("/master")
    public ResponseEntity<MasterDto> saveMaster(@RequestBody MasterEntity entity){
        MasterDto masterDto = null;
        try {
            masterDto = masterService.saveMaster(entity);
        } catch (MasterNotFoundException e){
            ResponseEntity.badRequest().body(e);
        } catch (Exception e){
            ResponseEntity.badRequest().body(e);
        }
        return ResponseEntity.ok(masterDto);
    }
}
