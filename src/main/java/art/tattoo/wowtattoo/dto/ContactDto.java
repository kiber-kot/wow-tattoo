package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.MasterEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@NoArgsConstructor
@Getter
@Setter
public class ContactDto {

    private Long id;

    private String phoneCode;

    private String phoneNumber;

    private String telegram;

    private String instagram;

    private String whatsApp;

    private String email;

    private String faceBook;

    private Long masterId;
}
