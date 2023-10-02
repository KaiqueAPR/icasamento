package com.icasamento.icasamento.models.convidado;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONVIDADO")
public class ConvidadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONV_CD_CONVIDADO")
    private Integer cdConvidado;

    @Column(name = "CONV_NM_CONVIDADO")
    private String nmConvidado;

    @Column(name = "CONV_NR_TELEFONE")
    private String nrTelefone;

    @Column(name = "CONV_NM_EMAIL")
    private String nmEmail;

    @Column(name = "CONV_TX_CPF")
    private String txCpf;

    @Column(name = "CONV_CD_SENHA")
    private String cdSenha;
}
