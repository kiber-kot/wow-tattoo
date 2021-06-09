package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterListRepository;
import art.tattoo.wowtattoo.dto.MasterListDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.MasterListMapper;
import art.tattoo.wowtattoo.service.MasterListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api")
public class MasterListPageController {

    @Autowired
    private MasterListRepository masterListRepository;
    @Autowired
    private MasterListMapper masterListMapper;
    @Autowired
    private MasterListService masterListService;

    @Autowired
    public MasterListPageController(MasterListRepository masterListRepository, MasterListMapper masterListMapper) {
        this.masterListRepository = masterListRepository;
        this.masterListMapper = masterListMapper;
    }

    @GetMapping("/masters")
    public ResponseEntity<List<MasterListDto>> getDefaultListMaster(){
        List<MasterEntity> entity = masterListRepository.findAll10();
        return ResponseEntity.ok().body(masterListMapper.toTdoList(entity));
    }

    @GetMapping("/masters/{id}")
    public ResponseEntity<List<MasterListDto>> getDefaultListMaster(@PathVariable("id") long id){
        List<MasterEntity> entity = masterListRepository.findAllByIdBetweenOrderByIdAsc(id);
        return ResponseEntity.ok().body(masterListMapper.toTdoList(entity));
    }

    @GetMapping("/masters/filter")
    public ResponseEntity<List<MasterListDto>> getFilterListMaster(
            @RequestParam(name = "city", required = false) List<String> city,
            @RequestParam(name = "experience", required = false) List<Integer> experience,
            @RequestParam(name = "price", required = false) List<Integer> price){

        return ResponseEntity.ok().body(masterListService.getDefaultMasterList(city,experience,price));
    }

    @GetMapping("/masters/filter/{id}")
    public ResponseEntity<List<MasterListDto>> getFilterListMaster(
            @PathVariable("id") long id,
            @RequestParam(name = "city", required = false) List<String> city,
            @RequestParam(name = "experience", required = false) List<Integer> experience,
            @RequestParam(name = "price", required = false) List<Integer> price){

        return ResponseEntity.ok().body(masterListService.getLimitByIdMasterList(id,city,experience,price));
    }
}
