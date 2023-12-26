package com.clientui.clientui.beans;

import java.util.Date;

import lombok.Data;

@Data
public class PaiementBean {

    private int id;

    private Integer idCommande;

    private Double montant;

    private Long numeroCarte;

   
}
