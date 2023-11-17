package com.icasamento.icasamento.models.cidade;

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
@Table(name = "CIDADE")
public class CidadeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CIDA_CD_CIDADE")
    private Integer cdCidade;

    @Column(name = "CIDA_NM_CIDADE")
    private String nmCidade;

    @Column(name = "CIDA_SG_SIGLA_ESTADO")
    private String sgEstado;
}
