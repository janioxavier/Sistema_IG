/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.acoes;

/**
 * Enumeração dos tipos de ações corporais
 * @author janioxavier
 */
public enum TipoCorporal implements Acao{
    BATER_PALMAS,
    PULAR,
    ABRIR_BRACOS,
    TOCAR_CABECA,
    TOCAR_ORELHAS,
    DAR_TCHAU,
    FAZER_LEGAL_MAO,
    FAZER_NAO_CABECA,
    FAZER_SIM_CABECA;

    @Override
    public TipoAcao getTipoAcao() {
        return TipoAcao.CORPORAL;
    }   
}
