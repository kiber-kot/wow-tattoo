package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.PortfolioRepository;
import art.tattoo.wowtattoo.dto.ContactDto;
import art.tattoo.wowtattoo.dto.PortfolioDto;
import art.tattoo.wowtattoo.entity.ContactEntity;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.PortfolioEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.mapping.PortfolioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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
    public ResponseEntity<?> savePortfolio(@PathVariable long id,
                                        @Valid
                                        @RequestBody List<PortfolioEntity> entity){
        Optional<MasterEntity> masterEntity = masterRepository.findById(id);
        try {
            if (masterEntity.isEmpty()) {
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + id + "' отсутствует в базе");
            }
            for (PortfolioEntity value : entity) {
                value.setMasterId(masterEntity.get());
            }
            portfolioRepository.saveAll(entity);
            return ResponseEntity.ok().body("Записы добавлены");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/portfolio/{id}")
    public ResponseEntity<?> updatePortfolio(@PathVariable long id,
                                           @Valid
                                           @RequestBody PortfolioEntity entity){
        Optional<MasterEntity> masterEntity = masterRepository.findById(id);
        try {
            if (masterEntity.isEmpty()) {
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + id + "' отсутствует в базе");
            }
            entity.setMasterId(masterEntity.get());
            return ResponseEntity.ok(portfolioMapper
                    .toDto(portfolioRepository
                            .save(entity)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/portfolio/{masterId}/{portfolioId}")
    public ResponseEntity<?> deletePortfolio(@PathVariable long masterId, long portfolioId){
        Optional<MasterEntity> masterEntity = masterRepository.findById(masterId);
        try{
            if(masterEntity.isEmpty()){
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + masterId + "' отсутствует в базе");
            }
            portfolioRepository.findById(portfolioId);
            return ResponseEntity.ok().body("У пользователь с id = '" +
                    masterId + "' удалена фотография с id = ' " + portfolioId);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/portfolio/{masterId}")
    public ResponseEntity<?> deleteAllPortfolio(@PathVariable long masterId){
        Optional<MasterEntity> masterEntity = masterRepository.findById(masterId);
        try{
            if(masterEntity.isEmpty()){
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + masterId + "' отсутствует в базе");
            }
            List<PortfolioEntity> list = portfolioRepository.findAllByMasterId(masterId);
            for(PortfolioEntity value : list){
                portfolioRepository.deleteById(value.getId());
            }
            return ResponseEntity.ok().body("У пользователь с id = '" +
                    masterId + "' удалены все фотографии");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}