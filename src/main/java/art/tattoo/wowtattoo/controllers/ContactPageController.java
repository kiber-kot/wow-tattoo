package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.ContactRepository;
import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dto.ContactDto;
import art.tattoo.wowtattoo.entity.ContactEntity;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.ContactMapper;
import art.tattoo.wowtattoo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@Transactional
@RequestMapping("/api")
public class ContactPageController {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private ContactMapper contactMapper;

    @PostMapping("/contact/{id}")
    public ContactDto saveContact(@PathVariable long id,
                                  @Valid
                                  @RequestBody ContactEntity entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        entity.setMasterId(masterEntity);
        ContactDto contactDto = contactMapper
                .toDto(contactRepository
                        .save(entity));
        return contactDto;
    }

    @PutMapping("/contact/{id}")
    public ContactDto updateContact(@PathVariable long id,
                                    @Valid
                                    @RequestBody ContactEntity entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        entity.setMasterId(masterEntity);
        return contactMapper
                .toDto(contactRepository
                        .save(entity));
    }
}