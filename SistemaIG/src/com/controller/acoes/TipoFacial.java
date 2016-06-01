/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.acoes;

/**
 *
 * @author janioxavier
 */
public enum TipoFacial implements Acao{
    PISCAR_1_OLHO,
    PISCAR_2_OLHOS,
    ESTIRAR_LINGUA,
    ABRIR_BOCA,
    FAZER_CARA_CHORO,
    FAZER_CARETA,
    SORRIR;

    @Override
    public TipoAcao getTipoAcao() {
        return TipoAcao.FACIAL;
    }
}
