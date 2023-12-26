package com.clientui.clientui.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.clientui.beans.CommandeBean;

@FeignClient(name = "microservice-commandes", url = "localhost:9002")
public interface MicroserviceCommandeProxy {

    @PostMapping(value = "/commandes")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
}
