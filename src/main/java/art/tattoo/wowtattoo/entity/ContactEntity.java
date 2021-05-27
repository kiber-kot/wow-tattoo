package art.tattoo.wowtattoo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(11)
    @Max(11)
    private String phoneNumber;
    private String telegram;
    private String instagram;
    private String whatsApp;
    @NotBlank
    @Email
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
