package com.icasamento.icasamento.models.tipopresente;

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
@Table(name = "TIPO_PRESENTE")
public class TipoPresenteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPR_CD_TIPO_PRESENTE")
    private Integer cdTipoPresente;

    @Column(name = "TIPR_NM_TIPO_PRESENTE")
    private String nmTipoPresente;
}
