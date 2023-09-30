package com.icasamento.icasamento.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRESENTE")
public class PresenteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRES_CD_PRESENTE")
    private Integer cdPresente;

    @Column(name = "PRES_NM_PRESENTE")
    private String nmPresente;

    @ManyToOne
    @JoinColumn(name = "PRES_CD_TIPO_PRESENTE")
    private TipoPresenteModel tipoPresenteModel;

    @Column(name = "PRES_TX_LINK")
    private String txLink;

    @Column(name = "PRES_VL_PRECO")
    private Float vlPreco;

    @Column(name = "PRES_TX_CAMINHO_IMAGEM")
    private String txCaminhoImagem;

}
