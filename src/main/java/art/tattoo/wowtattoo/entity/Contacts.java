package art.tattoo.wowtattoo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneCode;
    private String phoneNumber;
    private String telegram;
    private String instagram;
    private String whatsApp;
    private String email;
    private boolean objectStatus;

    @OneToOne
    @JoinColumn
    private Users userId;
}
