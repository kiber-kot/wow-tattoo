package art.tattoo.wowtattoo.controllers;


import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.ContactEntity;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.exeption.RequiredFieldIsNotFilledInException;
import art.tattoo.wowtattoo.mapping.MasterMapper;
import art.tattoo.wowtattoo.service.MasterService;
import art.tattoo.wowtattoo.service.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Optional;

@RestController()
@Transactional
@RequestMapping("/api")
public class MasterPageController {

    @Autowired
    private MasterService masterService;

    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private MasterMapper masterMapper;
    @Autowired
    private MasterServiceImpl masterServiceIml;


    @GetMapping("/status")
    public ResponseEntity checkServerStatus(){
        try{
            return  ResponseEntity.ok("Server работает");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер не работает");
        }
    }

    @GetMapping("/master/{id}")
    public ResponseEntity<?> getOneMaster(@PathVariable long id){
        MasterDto masterDto;
        try {
            if(masterRepository.findById(id).isEmpty()){
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '"+ id + "' отсутствует в базе");
            }
            masterDto = masterService.getMaster(id);
            return ResponseEntity.ok(masterDto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/master")
    public ResponseEntity<?> saveMaster(@Valid @RequestBody MasterEntity entity){
        try {
            return ResponseEntity.ok(masterServiceIml.saveMaster(entity));
        } catch (MasterNotFoundException | RequiredFieldIsNotFilledInException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/master")
    public ResponseEntity<?> updateMaster(@Valid @RequestBody MasterEntity entity){
        try {
            if (masterRepository.findById(entity.getId()).isEmpty()) {
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + entity.getId() + "' отсутствует в базе");
            }
            return ResponseEntity.ok(masterMapper
                    .toDto(masterRepository
                            .saveAndFlush(entity)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/master/{id}")
    public ResponseEntity<?> deleteMaster(@PathVariable long id){
        Optional<MasterEntity> masterEntity = masterRepository.findById(id);
        try{
            if(masterEntity.isEmpty()){
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + id + "' отсутствует в базе");
            }
            masterRepository.deleteById(id);
            return ResponseEntity.ok().body("Пользователь с id = '" + id + "' удален");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
