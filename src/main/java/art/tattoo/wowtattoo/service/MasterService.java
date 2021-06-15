package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.exeption.RequiredFieldIsNotFilledInException;

import java.util.List;

public interface MasterService {

    MasterDto getMaster(long id) throws MasterNotFoundException, RequiredFieldIsNotFilledInException;

    List<MasterEntity> getAllMasters();

    MasterDto saveMaster(MasterEntity masterEntity) throws MasterNotFoundException, RequiredFieldIsNotFilledInException;
}
