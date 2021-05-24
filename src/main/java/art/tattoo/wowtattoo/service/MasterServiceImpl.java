package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.mapping.MasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {

    private final MasterRepository masterRepository;

    @Autowired
    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Autowired
    private MasterMapper masterMapper;

    @Override
    public MasterDto getMaster(long id) throws MasterNotFoundException {
        MasterEntity masterEntity = masterRepository.findById(id).get();
        MasterDto masterDto =  masterMapper.toDto(masterEntity);
        if(masterEntity == null){
            throw new MasterNotFoundException("Мастер не найден");
        }
            return masterDto;
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
