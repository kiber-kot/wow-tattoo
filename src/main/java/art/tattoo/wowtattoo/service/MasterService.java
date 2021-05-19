package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;

import java.util.List;

public interface MasterService {

    MasterEntity getMaster(long id) throws MasterNotFoundException;

    List<MasterEntity> getAllMasters();

    void saveMaster(MasterEntity masterEntity);
}
