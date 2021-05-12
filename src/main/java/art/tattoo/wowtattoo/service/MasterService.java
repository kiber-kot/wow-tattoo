package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.entity.Masters;

import java.util.List;

public interface MasterService {

    Masters getMaster(long id);

    List<Masters> getAllMasters();

    void saveMaster(Masters masters);
}
