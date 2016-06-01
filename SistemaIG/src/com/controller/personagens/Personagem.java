/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.personagens;

import com.controller.acoes.Acao;
import com.controller.acoes.TipoCorporal;
import com.controller.acoes.TipoFacial;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author Jânio Xavier
 */
public abstract class Personagem {    
    private transient TipoPersonagem tipoPersonagem;    
    
    public Personagem(TipoPersonagem tipoPersonagem) {
        this.tipoPersonagem = tipoPersonagem;
    }
    
    public TipoPersonagem getTipoPersonagem() {
        return tipoPersonagem;
    }
    
    /**
     * busca o icone da ação de dado personagem.
     * @param acao ação do personagem
     * @return o icone da ação do personagem
     */
    public Icon getIconAcao(Acao acao) {
        Icon icon = null;
        if (acao instanceof TipoFacial) {
            icon = getIconAcaoFacial((TipoFacial) acao);
        } else if (acao instanceof TipoCorporal) {
            icon = getIconAcaoCorporal((TipoCorporal) acao);
        }
        return icon;
    }
    
    public Icon getIconAcaoFacial(TipoFacial facial) {
        Icon icon = null;
        switch(facial) {
            case ABRIR_BOCA:
                icon = getIconAbrirBoca();break;
            case ESTIRAR_LINGUA:
                icon = getIconEstirarLingua(); break;
            case FAZER_CARA_CHORO:
                icon = getIconFazerCaraChoro(); break;
            case FAZER_CARETA:
                icon = getIconFazerCareta(); break;
            case PISCAR_1_OLHO:
                icon = getIconPiscar1Olho(); break;
            case PISCAR_2_OLHOS:
                icon = getIconPiscar2Olho(); break;
            case SORRIR:
                icon = getIconSorrir(); break;
            default:
                break;
        }
        return icon;
    }        

    protected abstract Icon getIconAbrirBoca();

    protected abstract Icon getIconEstirarLingua();

    protected abstract Icon getIconFazerCaraChoro();

    protected abstract Icon getIconFazerCareta();

    protected abstract Icon getIconPiscar1Olho();

    protected abstract Icon getIconPiscar2Olho();

    protected abstract Icon getIconSorrir();
    
    public Icon getIconAcaoCorporal(TipoCorporal corporal) {
        Icon icon = null;
        switch(corporal) {
            case ABRIR_BRACOS:
                icon = getIconAbrirBracos(); break;
            case BATER_PALMAS:
                icon = getIconBaterPalmas(); break;
            case DAR_TCHAU:
                icon = getIconDarTchau(); break;
            case FAZER_LEGAL_MAO:
                icon = getIconFazerLegalMao(); break;
            case FAZER_NAO_CABECA:
                icon = getIconFazerNaoCabeca(); break;
            case FAZER_SIM_CABECA:
                icon = getIconFazerSimCabeca(); break;
            case PULAR:
                icon = getIconPular(); break;
            case TOCAR_CABECA:
                icon = getIconTocarCabeca(); break;
            case TOCAR_ORELHAS:
                icon = getIconTocarOrelha(); break;
            default:
                break;                        
        }
        return icon;
    }

    protected abstract Icon getIconAbrirBracos();

    protected abstract Icon getIconBaterPalmas();

    protected abstract Icon getIconDarTchau();

    protected abstract Icon getIconFazerLegalMao();

    protected abstract Icon getIconFazerNaoCabeca();

    protected abstract Icon getIconFazerSimCabeca();

    protected abstract Icon getIconPular();

    protected abstract Icon getIconTocarCabeca();

    protected abstract Icon getIconTocarOrelha();
}
