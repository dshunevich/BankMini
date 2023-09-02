package ru.sberbank.jd.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.Transfer;

@Service
public interface TransferService {

    public Transfer createNewTransfer(Transfer transfer);

    public Transfer getTransferById(int id);

    public List<Transfer> getClientsTransfers(int clientid);

    public Transfer updateTransfer(Transfer transfer);

}
