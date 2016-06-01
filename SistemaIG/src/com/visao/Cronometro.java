/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Jânio Xavier
 */
public class Cronometro implements Runnable {
    private boolean comTexto;
    private boolean isFinalizado;
    private int tempo;
    private JLabel texto;

    public Cronometro(int tempo, JLabel texto) {
        this.tempo = tempo;
        this.texto = texto;
        comTexto = true;
    }
    
    public Cronometro(int tempo) {
        comTexto = false;
    }

    public void setTempo(int tempo) {
        if (tempo > 0) {
            this.tempo = tempo;
        }
    }

    public void finalizar() {
        isFinalizado = true;
    }

    public boolean isFinalizado() {
        return isFinalizado;
    }

    @Override
    public void run() {
        isFinalizado = false;
        int tempo = this.tempo;
        while (tempo > 0) {
            if (comTexto) {
                texto.setText(texto.getText() + tempo);
            }
            aguardarSegundo();
            tempo--;
        }
        
        if(comTexto) {
            texto.setText("");
        }
        isFinalizado = true;
    }        

    private void aguardarSegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            texto.setText("");
        }
    }
}
