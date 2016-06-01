/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visao;

import com.controller.acoes.Acao;
import com.controller.ControladorJogo;
import com.controller.acoes.TipoAcao;
import com.controller.acoes.TipoCorporal;
import com.controller.acoes.TipoFacial;
import com.controller.personagens.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Monster
 */
public class TelaJogoUI extends javax.swing.JFrame {

    private static final int TEMPO_IMITACAO = 30;
    private static final int TEMPO_ACAO = 5;
    private static final int TEMPO_COMEMORACAO = 5;        
    private Comemoracao comemoracao;
    private List<Personagem> personagens;
    private Cronometro cronometroAcao;
    private Cronometro cronometroImitacao;
    private ControladorJogo controlador;
    private String nomeJogador;

    public TelaJogoUI(ControladorJogo controlador) {
        initComponents();
        this.nomeJogador = controlador.getJogador().getNome();
        this.controlador = controlador;
        init();
    }

    /**
     * Creates new form TelaJogoUI
     */
    public TelaJogoUI() {
        initComponents();                
        init();
    }
    
    private void init() {
        personagens = new ArrayList<>();
        cronometroAcao = new Cronometro(TEMPO_IMITACAO, jLabelTempoAcao);
        cronometroImitacao = new Cronometro(TEMPO_IMITACAO, jLabelTempoImitacao);
        for (TipoPersonagem personagem : TipoPersonagem.values()){
            switch(personagem) {
                case CACHORRO:
                    personagens.add(new Cachorro(personagem));break;
                case GATO:
                    personagens.add(new Gato(personagem)); break;
                case MENINA:
                    personagens.add(new Menina(personagem)); break;
                case MENINO:
                    personagens.add(new Menino(personagem)); break;
            }
        }
        jLabelAcaoMostrada.setVisible(true);
        jLabelAcaoMostrada.setIcon(new Menina(TipoPersonagem.MENINA).getIconAcao(TipoFacial.ABRIR_BOCA));
        jButtonImitarAcao.setVisible(false);             
        comemoracao = new Comemoracao();
    }

    public static void inicializarJanela(ControladorJogo controlador) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogoUI(controlador).setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personagemButtonGroup = new javax.swing.ButtonGroup();
        acaoButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonIniciarJogada = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabelAcaoMostrada = new javax.swing.JLabel();
        jButtonImitarAcao = new javax.swing.JButton();
        jLabelTempoAcao = new javax.swing.JLabel();
        jLabelTempoImitacao = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("MenuJogo"));

        jButtonIniciarJogada.setText("Iniciar Jogada");
        jButtonIniciarJogada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarJogadaActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIniciarJogada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButtonIniciarJogada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setAutoscrolls(true);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabelAcaoMostrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagens/dança.gif"))); // NOI18N

        jLayeredPane1.setLayer(jLabelAcaoMostrada, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelAcaoMostrada)
                .addGap(48, 48, 48))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAcaoMostrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        jButtonImitarAcao.setText("Imitar Acao");
        jButtonImitarAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImitarAcaoActionPerformed(evt);
            }
        });

        jLabelTempoAcao.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jLabelTempoAcao.setText("cronometro");
        jLabelTempoAcao.setName(""); // NOI18N

        jLabelTempoImitacao.setText("Realiza a ação em");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jButtonImitarAcao))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(259, 259, 259)
                                .addComponent(jLabelTempoAcao)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabelTempoImitacao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelTempoAcao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTempoImitacao)
                .addGap(25, 25, 25)
                .addComponent(jButtonImitarAcao)
                .addGap(26, 26, 26))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Personagens"));

        personagemButtonGroup.add(jRadioButton1);
        jRadioButton1.setText("Menino");

        personagemButtonGroup.add(jRadioButton2);
        jRadioButton2.setText("Menina");

        personagemButtonGroup.add(jRadioButton3);
        jRadioButton3.setText("Gato");

        personagemButtonGroup.add(jRadioButton4);
        jRadioButton4.setText("Cachorro");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Ação"));

        acaoButtonGroup.add(jRadioButton5);
        jRadioButton5.setText("Facial");

        acaoButtonGroup.add(jRadioButton6);
        jRadioButton6.setText("Corporal");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Nivel"));

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(6);
        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(2);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarJogadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarJogadaActionPerformed
        // TODO add your handling code here:
        TipoAcao tipoAcao;
        int nivel;
        TipoPersonagem tipoPersonagem = getPersonagemSelecionado();
        List<Acao> acoes;
        
        if (tipoPersonagem != null) {
            tipoAcao = getAcaoSelecionada();
            nivel = jSlider1.getValue();
            acoes = controlador.inicializarJogada(tipoPersonagem, tipoAcao, nivel);
            iniciarRodada(tipoPersonagem, acoes);
            armazenarProgresso();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um personagem!",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIniciarJogadaActionPerformed

    private void jButtonImitarAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImitarAcaoActionPerformed
        // TODO add your handling code here:
        if (controlador.avaliarImitacao(null)) {
            
        } else {
            
        }
    }//GEN-LAST:event_jButtonImitarAcaoActionPerformed

    private void armazenarProgresso() throws HeadlessException {
        try {
            controlador.armazenarProgresso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "aviso", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void iniciarRodada(TipoPersonagem personagem, List<Acao> acoes) {
        for (Acao acao : acoes) {
            mostrarAcaoPersonagem(personagem, acao);
            aguardarTempoAcao();
            aguardarAcaoJogador();
        }                                        
    }

    private void aguardarAcaoJogador() {
        new Thread(cronometroImitacao).start();
    }

    private void aguardarTempoAcao() {
        new Thread(cronometroAcao).start();
        while (!cronometroAcao.isFinalizado()) {
            
        }
    }
    
    private void mostrarAcaoPersonagem(TipoPersonagem tipoPersonagem, Acao acao) {
        for (Personagem personagem : personagens) {
            if (tipoPersonagem == personagem.getTipoPersonagem()) {
                jLabelAcaoMostrada.setIcon(personagem.getIconAcao(acao));
                jLabelAcaoMostrada.setVisible(true);
                break;
            }
        }        
    }       

    private TipoPersonagem getPersonagemSelecionado() {
        TipoPersonagem personagemSelecionado = null;
        String texto = null;
        Enumeration<AbstractButton> personagensButton
                = personagemButtonGroup.getElements();
        for (; personagensButton.hasMoreElements();) {
            AbstractButton button = personagensButton.nextElement();
            if (button.isSelected()) {
                texto = button.getText().toUpperCase();
                personagemSelecionado = TipoPersonagem.valueOf(texto);
                break;
            }
        }
        return personagemSelecionado;
    }

    private TipoAcao getAcaoSelecionada() {
        TipoAcao acaoSelecionada = null;
        String texto = null;
        Enumeration<AbstractButton> acoesButtons
                = acaoButtonGroup.getElements();
        for (; acoesButtons.hasMoreElements();) {
            AbstractButton button = acoesButtons.nextElement();
            if (button.isSelected()) {
                texto = button.getText().toUpperCase();
                acaoSelecionada = TipoAcao.valueOf(texto);
                break;
            }
        }
        return acaoSelecionada;
    }                 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            ControladorJogo controlador = new ControladorJogo();
            controlador.iniciarJogo("João", "Marya");
            inicializarJanela(controlador);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaJogoUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaJogoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup acaoButtonGroup;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonImitarAcao;
    private javax.swing.JButton jButtonIniciarJogada;
    private javax.swing.JButton jButtonIniciarJogo;
    private javax.swing.JButton jButtonIniciarJogo1;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelAcaoMostrada;
    private javax.swing.JLabel jLabelTempoAcao;
    private javax.swing.JLabel jLabelTempoImitacao;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.ButtonGroup personagemButtonGroup;
    // End of variables declaration//GEN-END:variables
}
