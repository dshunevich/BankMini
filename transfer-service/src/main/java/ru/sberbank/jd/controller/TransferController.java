package ru.sberbank.jd.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.jd.entity.Transfer;
import ru.sberbank.jd.service.TransferService;

@Slf4j
@RestController
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/client")
    public List<Transfer> getClientsTransfers(@RequestParam(value = "clientId") int clientId) {
        log.info("GET request by client id = " + clientId);
        return transferService.getClientsTransfers(clientId);
    }

    @GetMapping("/{id}")
    public Transfer getTransferById(@PathVariable(name = "id") int id) {
        log.info("GET request by transfer id = " + id);
        return transferService.getTransferById(id);
    }

    @PostMapping
    public Transfer createNewTransfer(@RequestBody Transfer transfer) {
        log.info("POST request for creating transfer :" + transfer);
        return transferService.createNewTransfer(transfer);
    }

    @PutMapping("/{id}")
    public Transfer updateTransfer(@PathVariable(name = "id") int id, @RequestBody Transfer transfer) {
        log.info("PUT request for transfer id = " + id);
        return transferService.updateTransfer(transfer);
    }


}
