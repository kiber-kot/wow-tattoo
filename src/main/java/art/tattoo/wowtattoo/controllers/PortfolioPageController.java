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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PortfolioPageController {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private PortfolioMapper portfolioMapper;
    @Autowired
    private MasterRepository masterRepository;


    @PostMapping("/portfolio/{id}")
    public ResponseEntity<PortfolioDto> savePortfolio(@PathVariable long id, @RequestBody PortfolioEntity entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        entity.setMasterId(masterEntity);
        PortfolioDto portfolioDto = portfolioMapper
                .toDto(portfolioRepository
                        .save(entity));
        return ResponseEntity.ok(portfolioDto);
    }
}