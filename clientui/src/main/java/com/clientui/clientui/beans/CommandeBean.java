package com.clientui.clientui.beans;

import java.util.Date;

import lombok.Data;

@Data
public class CommandeBean {

    private int id;

    private Integer productId;

    private Date dateCommande;

    private Integer quantite;

    private Boolean commandePayee;

   
}
