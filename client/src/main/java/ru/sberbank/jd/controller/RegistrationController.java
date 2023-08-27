package ru.sberbank.jd.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.service.ClientService;

@Controller
@AllArgsConstructor
public class RegistrationController {

    ClientService clientService;

    @GetMapping("/registration")
    public String registrationGet(Model model){
        model.addAttribute("client", new Client());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute Client client, Model model) {
        if (!clientService.exists(client.getPassportNum())) {
            clientService.save(client);
            fillModel(model, false, "Registration completed", null);
            model.addAttribute("client", client);
        }
        else {
            fillModel(model, true, "Registration failed", "User registration error");
        }
        return "result";
    }
    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable int id, Model model) {
        Client client = new Client();
        client.setClientId(id);
        model.addAttribute("client", client);
        return "edit";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Client client, Model model) {
        if (clientService.exists(client.getPassportNum())) {
            clientService.update(client);
            fillModel(model, false, "Update completed",null);
            model.addAttribute("client", client);
        }
        else {
            fillModel(model, true, "Update failed", "User update error");
        }
        return "result";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        if (clientService.existsAndActive(id)) {
            clientService.delete(id);
            fillModel(model, false, "Delete completed",null);
        }
        else {
            fillModel(model, true, "Delete failed", "User delete error");
        }
        return "index";
    }

    private void fillModel(Model model, boolean error, String operation, String message) {
        model.addAttribute("userError", error);
        model.addAttribute("operation", operation);
        model.addAttribute("errorMessage", message);
    }
}