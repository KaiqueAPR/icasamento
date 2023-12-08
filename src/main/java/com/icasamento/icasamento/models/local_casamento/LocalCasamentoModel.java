package com.icasamento.icasamento.models.local_casamento;

import com.icasamento.icasamento.models.cidade.CidadeModel;
import com.icasamento.icasamento.models.estado.EstadoModel;
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
@Table(name = "LOCAL_CASAMENTO")
public class LocalCasamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCA_CD_LOCAL_CASAMENTO")
    private Integer cdLocalCasamento;

    @Column(name = "LOCA_NM_LOCAL_CASAMENTO")
    private String nmLocalCasamento;

    @Column(name = "LOCA_QTD_CONVIDADOS")
    private Integer qtdConvidados;

    @ManyToOne
    @JoinColumn(name = "CIDA_CD_CIDADE")
    private CidadeModel cidadeModel;

    @ManyToOne
    @JoinColumn(name = "ESTA_CD_ESTADO")
    private EstadoModel estadoModel;

    @Column(name = "LOCA_TX_URL_REDE_SOCIAL")
    private String txUrlRedeSocial;

    @Column(name = "LOCA_TX_URL_IMAGEM")
    private String txUrlImagem;
}
