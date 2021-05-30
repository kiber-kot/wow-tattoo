package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.PortfolioRepository;
import art.tattoo.wowtattoo.dao.StyleRepository;
import art.tattoo.wowtattoo.dto.PortfolioDto;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.PortfolioEntity;
import art.tattoo.wowtattoo.entity.ReviewEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.mapping.PortfolioMapper;
import art.tattoo.wowtattoo.mapping.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Transactional
@RequestMapping("/api")
public class StylePageController {

    @Autowired
    private StyleRepository styleRepository;
    @Autowired
    private StyleMapper styleMapper;
    @Autowired
    private MasterRepository masterRepository;

    @PostMapping("/style/{id}")
    public ResponseEntity saveStyle(@PathVariable long id,
                                    @Valid
                                    @RequestBody List<StyleEntity> entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        for(StyleEntity value: entity){
            value.setMasterId(masterEntity);
        }
        styleRepository.saveAll(entity);
        return ResponseEntity.ok().body("Записы добавлены");
    }

    @PutMapping("/style/{id}")
    public ResponseEntity<?> updateStyle(@PathVariable long id,
                                             @Valid
                                             @RequestBody List<StyleEntity> entity){
        Optional<MasterEntity> masterEntity = masterRepository.findById(id);
        try {
            if (masterEntity.isEmpty()) {
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" +
                        id + "' отсутствует в базе");
            }
            for(StyleEntity value: entity){
                value.setMasterId(masterEntity.get());
            }
            styleRepository.saveAll(entity);
            return ResponseEntity.ok().body("Записы добавлены");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
