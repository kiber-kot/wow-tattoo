package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.exeption.RequiredFieldIsNotFilledInException;
import art.tattoo.wowtattoo.mapping.MasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
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
    public MasterDto saveMaster(MasterEntity masterEntity) throws MasterNotFoundException, RequiredFieldIsNotFilledInException {

        if(masterEntity.getMasterName().isEmpty() || masterEntity.getMasterName() == null){
            throw new RequiredFieldIsNotFilledInException("Отсутствует обязательное поле masterName");
        }
        if(masterEntity.getCity().isEmpty() || masterEntity.getCity() == null){
            throw new RequiredFieldIsNotFilledInException("Отсутствует обязательное поле city");
        }
        if(masterEntity.getExperience() <= 0 || masterEntity.getExperience() >= 100){
            throw new RequiredFieldIsNotFilledInException("Отсутствует обязательное поле experience или значение данного поля не входит в отрезок 1-99");
        }

        MasterDto masterDto = masterMapper
                .toDto(masterRepository
                        .save(masterEntity));
        return masterDto;
    }
}
