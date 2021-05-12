package art.tattoo.wowtattoo.controllers;


import art.tattoo.wowtattoo.entity.Masters;
import art.tattoo.wowtattoo.service.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class MasterPageController {

    MasterServiceImpl masterService;

    @Autowired
    private MasterPageController(MasterServiceImpl masterService){
        this.masterService = masterService;
    }

    @GetMapping("/master/{id}")
    public Masters getMasters(@PathVariable int id){
        return masterService.getMaster(id);
    }

    @GetMapping("/master")
    public List<Masters> getAllMasters(){
        return masterService.getAllMasters();
    }

    @PostMapping("/master")
    public Masters addNewMaster(@RequestBody Masters masters){
        masterService.saveMaster(masters);
        return masters;
    }

}
