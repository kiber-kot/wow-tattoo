package art.tattoo.wowtattoo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneCode;
    private String phoneNumber;
    private String telegram;
    private String instagram;
    private String whatsApp;
    private String email;
    private String faceBook;

    @OneToOne
    @JoinColumn(name = "master_id")
    private MasterEntity masterId;

    @JsonCreator
    public ContactEntity (@JsonProperty("master_id") Long masterId ) {
        this.setId(masterId);
    }
}
