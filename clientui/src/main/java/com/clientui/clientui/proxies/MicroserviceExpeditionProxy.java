package com.clientui.clientui.proxies;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.clientui.FeignConfig;
import com.clientui.clientui.beans.ExpeditionBean;

@FeignClient(name ="microservice-produit", url = "localhost:9001")
//@FeignClient(name ="gatway-server" , configuration = FeignConfig.class)
@LoadBalancerClient(name ="microservice-expedition")

public interface MicroserviceExpeditionProxy {
	
    @GetMapping(value = "/Expeditions")
	public List<ExpeditionBean> getListExpedition();

    @GetMapping(value = "/Expedition/{id}")
    public ExpeditionBean getExpeditionById(@PathVariable("id") int id);
    
    @PutMapping(value = ("/Expedition"))
    public ExpeditionBean modifierExpedition(@RequestBody ExpeditionBean expedition);
    
	@PostMapping(value = "/Expeditions")
	public ExpeditionBean ajouterExpedition(@RequestBody ExpeditionBean expedition);



}
