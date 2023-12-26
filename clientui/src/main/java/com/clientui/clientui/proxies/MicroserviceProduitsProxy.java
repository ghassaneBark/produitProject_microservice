package com.clientui.clientui.proxies;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clientui.clientui.FeignConfig;
import com.clientui.clientui.beans.ProductBean;

//@FeignClient(name ="microservice-produit", url = "localhost:9001")
@FeignClient(name ="gatway-server" , configuration = FeignConfig.class)
@LoadBalancerClient(name ="microservice-produit")

public interface MicroserviceProduitsProxy {
	
	  @GetMapping(value = "/produit/Produits")
	   List<ProductBean> listeDesProduits();

	   @GetMapping( value = "/produit/Produits/{id}")
	   ProductBean recupererUnProduit(@PathVariable("id") int id);

}
