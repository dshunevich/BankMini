package ru.sberbank.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.service.ClientService;

@Controller
public class RegistrationController {
    @Autowired
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
            model.addAttribute("userError", false);
            model.addAttribute("client", client);
            model.addAttribute("operation", "Registration completed");
        }
        else {
            model.addAttribute("userError", true);
            model.addAttribute("errorMessage", "User registration error");;
            model.addAttribute("operation", "Registration failed");
        }
        return "result";
    }
}