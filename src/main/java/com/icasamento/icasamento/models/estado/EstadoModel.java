package com.icasamento.icasamento.models.estado;

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
@Table(name = "ESTADO")
public class EstadoModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ESTA_CD_ESTADO")
        private Integer cdEstado;

        @Column(name = "ESTA_NM_ESTADO")
        private String nmEstado;

        @Column(name = "ESTA_SG_SIGLA")
        private String sgEstado;
}
