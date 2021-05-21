package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.attributes.Styles;
import art.tattoo.wowtattoo.entity.MasterEntity;

import javax.persistence.*;

public class StyleDto {

    private Long id;

    private Styles styles;

    private MasterEntity masterId;
}
