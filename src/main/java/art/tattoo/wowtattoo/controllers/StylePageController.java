package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.PortfolioRepository;
import art.tattoo.wowtattoo.dao.StyleRepository;
import art.tattoo.wowtattoo.dto.PortfolioDto;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.PortfolioEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import art.tattoo.wowtattoo.mapping.PortfolioMapper;
import art.tattoo.wowtattoo.mapping.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StylePageController {

    @Autowired
    private StyleRepository styleRepository;
    @Autowired
    private StyleMapper styleMapper;
    @Autowired
    private MasterRepository masterRepository;

    @PostMapping("/style/{id}")
    public ResponseEntity<StyleDto> saveStyle(@PathVariable long id, @RequestBody StyleEntity entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        entity.setMasterId(masterEntity);
        StyleDto styleDto = styleMapper
                .toDto(styleRepository
                        .save(entity));
        return ResponseEntity.ok(styleDto);
    }
}
