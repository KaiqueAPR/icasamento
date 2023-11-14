package com.icasamento.icasamento.models.casamento;

import com.icasamento.icasamento.models.convidado.ConvidadoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "CASAMENTO")
public class CasamentoModel {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CASA_CD_CASAMENTO")
    private Integer cdCasamento;
    
    private ConvidadoModel convidadoModel;
    // TODO: 13/11/2023

    private Date dtCasamento;
    // TODO: 13/11/2023

    private Integer cdEstado;
    // TODO: 13/11/2023

    private Integer cdCidade;
    // TODO: 13/11/2023
}