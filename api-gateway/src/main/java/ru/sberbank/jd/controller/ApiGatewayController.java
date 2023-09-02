package ru.sberbank.jd.controller;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.sberbank.jd.config.AppProperties;

@Slf4j
@RestController
public class ApiGatewayController {

//    private final RestTemplate restTemplate;
//
//    public ApiGatewayController (RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @Autowired
    private AppProperties properties;

    @RequestMapping(value = "/api/clients/**")
    @ResponseBody
    public ResponseEntity<String> clientRequest() {
        log.info("redirect request to client-service");
        return new ResponseEntity<>("Hello, it's a API-CLIENT service", HttpStatusCode.valueOf(200));
//        return new ResponseEntity<>();
    }

    @RequestMapping(value = "/api/accounts/**")
    @ResponseBody
    public ResponseEntity<String> accountRequest() {
        return new ResponseEntity<>("Hello, it's a API-ACCOUNT service", HttpStatusCode.valueOf(200));
    }

    @RequestMapping(value = "/api/transfers/client")
    @ResponseBody
    public ResponseEntity<String> getClientTransfers(@RequestParam(name = "clientId") int clientId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("rqUID", UUID.randomUUID().toString());
        log.info("[getClientTransfers]. Redirect request: " + headers.get("rqUID") + " to transfer-service");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://transfer-service:8080/transfers/client")
                .queryParam("clientId", clientId);
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(headers), String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @RequestMapping(value = "/api/transfers/{id}")
    @ResponseBody
    public ResponseEntity<String> getTransfer(@PathVariable(name = "id") int id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("rqUID", UUID.randomUUID().toString());
        log.info("[getTransfer]. Redirect request: " + headers.get("rqUID") + " to transfer-service");
        ResponseEntity<String> response = restTemplate.exchange("http://transfer-service:8080/transfers/" + id, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @RequestMapping(value = "/api/deposits/**")
    @ResponseBody
    public ResponseEntity<String> depositRequest() {
        return new ResponseEntity<>("Hello, it's a API-DEPOSIT service", HttpStatusCode.valueOf(200));
    }

}
