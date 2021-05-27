package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.RatingRepository;
import art.tattoo.wowtattoo.dao.StyleRepository;
import art.tattoo.wowtattoo.dto.RatingDto;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.RatingEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import art.tattoo.wowtattoo.mapping.RatingMapper;
import art.tattoo.wowtattoo.mapping.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("/api")
public class RatingPageController {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RatingMapper ratingMapper;
    @Autowired
    private MasterRepository masterRepository;

    @PostMapping("/rating/{id}")
    public ResponseEntity<RatingDto> saveStyle(@PathVariable long id,
                                               @Valid
                                               @RequestBody RatingEntity entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        entity.setMasterId(masterEntity);
        RatingDto ratingDto = ratingMapper
                .toDto(ratingRepository
                        .save(entity));
        return ResponseEntity.ok(ratingDto);
    }
}
