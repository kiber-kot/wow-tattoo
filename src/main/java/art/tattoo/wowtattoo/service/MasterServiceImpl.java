package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {

    private final MasterRepository masterRepository;

    @Autowired
    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public MasterEntity getMaster(long id) throws MasterNotFoundException {

        MasterEntity masterEntity = masterRepository.findById(id).get();

        if(masterEntity == null){
            throw new MasterNotFoundException("Мастер не найден");
        }
            return masterEntity;

    }

    @Override
    public List<MasterEntity> getAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    public void saveMaster(MasterEntity masterEntity) {
        masterRepository.save(masterEntity);
    }
}
