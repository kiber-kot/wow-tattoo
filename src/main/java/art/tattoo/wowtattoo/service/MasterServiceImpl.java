package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.entity.Masters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MasterServiceImpl implements MasterService {

    private final MasterRepository masterRepository;

    @Autowired
    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Masters getMaster(long id) {
        Masters masters = null;
        Optional<Masters> optional = masterRepository.findById(id);
        if (optional.isPresent()) {
            masters = optional.get();
        }
        return masters;
    }

    @Override
    public List<Masters> getAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    public void saveMaster(Masters masters) {
        masterRepository.save(masters);
    }
}
