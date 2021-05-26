package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dto.ContactDto;
import art.tattoo.wowtattoo.entity.ContactEntity;

public interface ContactService {
    ContactDto saveContact(ContactEntity contactEntity);
}
