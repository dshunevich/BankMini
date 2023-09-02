package ru.sberbank.jd.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.Transfer;
import ru.sberbank.jd.entity.TransferStatus;
import ru.sberbank.jd.repository.TransferRepository;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    private TransferRepository repo;

    @Override
    public Transfer createNewTransfer(Transfer transfer) {
        transfer.setSubmitDateTime(LocalDateTime.now());
        transfer.setStatus(TransferStatus.PENDING);
        return repo.save(transfer);
    }

    @Override
    public Transfer getTransferById(int id) {
        return repo.findById(id);
    }

    @Override
    public List<Transfer> getClientsTransfers(int clientid) {
        return repo.findByClientId(clientid);
    }

    @Override
    public Transfer updateTransfer(Transfer transfer) {
        Transfer updTransfer = getTransferById(transfer.getId());
        if (updTransfer == null) {
            return null;
        }
        updTransfer.setStatus(transfer.getStatus());
        return repo.save(updTransfer);
    }


}
