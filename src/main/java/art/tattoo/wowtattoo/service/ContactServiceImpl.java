package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dao.ContactRepository;
import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dto.ContactDto;
import art.tattoo.wowtattoo.entity.ContactEntity;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.ContactMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactMapper contactMapper;


    @Override
    public ContactDto saveContact(ContactEntity contactEntity){
        ContactDto contactDto = contactMapper
                .toDto(contactRepository
                        .save(contactEntity));
        return contactDto;
    }
}
