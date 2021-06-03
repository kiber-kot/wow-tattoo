package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterListRepository;
import art.tattoo.wowtattoo.dto.MasterListDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.MasterListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api")
public class MasterListPageController {

    private final MasterListRepository masterListRepository;

    private final MasterListMapper masterListMapper;

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
}
