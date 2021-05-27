package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.PortfolioRepository;
import art.tattoo.wowtattoo.dto.ContactDto;
import art.tattoo.wowtattoo.dto.PortfolioDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.PortfolioEntity;
import art.tattoo.wowtattoo.mapping.PortfolioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@Transactional
@RequestMapping("api")
public class PortfolioPageController {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private PortfolioMapper portfolioMapper;
    @Autowired
    private MasterRepository masterRepository;


    @PostMapping("/portfolio/{id}")
    public ResponseEntity savePortfolio(@PathVariable long id,
                                        @Valid
                                        @RequestBody List<PortfolioEntity> entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        for(PortfolioEntity value: entity){
            value.setMasterId(masterEntity);
        }
        portfolioRepository.saveAll(entity);
        return ResponseEntity.ok().body("Записы добавлены");
    }
}