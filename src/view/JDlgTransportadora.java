/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import bean.Ebs_Transportadora;
import dao.Ebs_transportadoraDAO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author bispo
 */
public class JDlgTransportadora extends javax.swing.JDialog {

    boolean incluir;
    boolean pesquisar;
    MaskFormatter maskCnpj;
    MaskFormatter maskTelefone;

    /**
     * Creates new form jDlgUsuario
     */
    public JDlgTransportadora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Transportadora");
        setLocationRelativeTo(null);
        habilitar(false);

        try {
            maskCnpj = new MaskFormatter("##.###.###/####-##");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ebs_jFmtcnpj.setFormatterFactory(new DefaultFormatterFactory(maskCnpj));

        try {
            maskTelefone = new MaskFormatter("(##)#####-####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ebs_jFmttelefone.setFormatterFactory(new DefaultFormatterFactory(maskTelefone));

    }

    private void habilitar(boolean status) {
        ebs_jTxtid_transportadora.setEnabled(status);
        ebs_jFmtcnpj.setEnabled(status);
        ebs_jTxtnome.setEnabled(status);
        ebs_jTxtresponsavel.setEnabled(status);
        ebs_jTxtemail.setEnabled(status);
        ebs_jFmttelefone.setEnabled(status);
        ebs_jTxtendereco.setEnabled(status);

        // Habilitar/Inabilitar botões
        ebs_jBtnIncluir.setEnabled(!status);
        ebs_jBtnAlterar.setEnabled(!status);
        ebs_jBtnPesquisar.setEnabled(!status);
        ebs_jBtnExcluir.setEnabled(!status);

        ebs_jBtnCancelar.setEnabled(status);
        ebs_jBtnConfirmar.setEnabled(status);

        if (!status) {
            limparCampos();
        }
    }

    private void limparCampos() {
        ebs_jTxtid_transportadora.setText("");
        ebs_jFmtcnpj.setText("");
        ebs_jTxtnome.setText("");
        ebs_jTxtresponsavel.setText("");
        ebs_jTxtemail.setText("");
        ebs_jFmttelefone.setText("");
        ebs_jTxtendereco.setText("");
    }

    public Ebs_Transportadora viewPbean() {
        Ebs_Transportadora transportadora = new Ebs_Transportadora();

        try {
            // Verificar se o campo ID da transportadora está vazio
            String idText = ebs_jTxtid_transportadora.getText();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O ID da transportadora não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            } // Adiciona o ID da transportadora na Classe
            transportadora.setEbs_id_transportadora(Integer.parseInt(idText));

            // Verificar se o nome da transportadora está vazio
            String nome = ebs_jTxtnome.getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome da transportadora não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            } // Adiciona o nome da transportadora na Classe
            transportadora.setEbs_nome(nome);

            // Verificar se o CNPJ está vazio
            String cnpj = ebs_jFmtcnpj.getText();
            if (cnpj.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O CNPJ não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            } // Adiciona o CNPJ da transportadora na Classe
            transportadora.setEbs_cnpj(cnpj);

            // Verificar se o responsável está vazio
            String responsavel = ebs_jTxtresponsavel.getText();
            if (responsavel.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O responsável não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            } // Adiciona o responsável da transportadora na Classe
            transportadora.setEbs_responsavel(responsavel);

            // Verificar se o email está vazio
            String email = ebs_jTxtemail.getText();
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O email não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            } // Adiciona o email da transportadora na Classe
            transportadora.setEbs_email(email);

            // Verificar se o telefone está vazio
            String telefone = ebs_jFmttelefone.getText();
            if (telefone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O telefone não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            } // Adiciona o telefone da transportadora na Classe
            transportadora.setEbs_telefone(telefone);

            // Verificar se o endereço está vazio
            String endereco = ebs_jTxtendereco.getText();
            if (endereco.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O endereço não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            } // Adiciona o endereço da transportadora na Classe
            transportadora.setEbs_endereco(endereco);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao converter valores", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JDlgTransportadora.class.getName()).log(Level.SEVERE, "Erro ao preencher transportadora", ex);
            return null;
        }
        return transportadora;
    }

    public void beanPview(Ebs_Transportadora transportadora) {
        ebs_jTxtid_transportadora.setText(String.valueOf(transportadora.getEbs_id_transportadora()));
        ebs_jTxtnome.setText(transportadora.getEbs_nome());
        ebs_jFmtcnpj.setText(transportadora.getEbs_cnpj());
        ebs_jTxtresponsavel.setText(transportadora.getEbs_responsavel());
        ebs_jTxtemail.setText(transportadora.getEbs_email());
        ebs_jFmttelefone.setText(transportadora.getEbs_telefone());
        ebs_jTxtendereco.setText(transportadora.getEbs_endereco());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ebs_jLblid_transportadora = new javax.swing.JLabel();
        ebs_JLblcnpj = new javax.swing.JLabel();
        ebs_jLblnome = new javax.swing.JLabel();
        ebs_jLblresponsavel = new javax.swing.JLabel();
        ebs_jLblemail = new javax.swing.JLabel();
        ebs_jLbltelefone = new javax.swing.JLabel();
        ebs_jLblendereco = new javax.swing.JLabel();
        ebs_jTxtid_transportadora = new javax.swing.JTextField();
        ebs_jFmtcnpj = new javax.swing.JFormattedTextField();
        ebs_jTxtnome = new javax.swing.JTextField();
        ebs_jTxtresponsavel = new javax.swing.JTextField();
        ebs_jTxtemail = new javax.swing.JTextField();
        ebs_jFmttelefone = new javax.swing.JFormattedTextField();
        ebs_jTxtendereco = new javax.swing.JTextField();
        ebs_jBtnIncluir = new javax.swing.JButton();
        ebs_jBtnAlterar = new javax.swing.JButton();
        ebs_jBtnExcluir = new javax.swing.JButton();
        ebs_jBtnConfirmar = new javax.swing.JButton();
        ebs_jBtnCancelar = new javax.swing.JButton();
        ebs_jBtnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ebs_jLblid_transportadora.setText("ID");

        ebs_JLblcnpj.setText("CNPJ");

        ebs_jLblnome.setText("Nome ");

        ebs_jLblresponsavel.setText("Responsável");

        ebs_jLblemail.setText("Email");

        ebs_jLbltelefone.setText("Telefone");

        ebs_jLblendereco.setText("Endereco");

        ebs_jTxtid_transportadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jTxtid_transportadoraActionPerformed(evt);
            }
        });

        ebs_jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        ebs_jBtnIncluir.setText("Incluir");
        ebs_jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jBtnIncluirActionPerformed(evt);
            }
        });

        ebs_jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        ebs_jBtnAlterar.setText("Alterar");
        ebs_jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jBtnAlterarActionPerformed(evt);
            }
        });

        ebs_jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deletar.png"))); // NOI18N
        ebs_jBtnExcluir.setText("Excluir");
        ebs_jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jBtnExcluirActionPerformed(evt);
            }
        });

        ebs_jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar1.png"))); // NOI18N
        ebs_jBtnConfirmar.setText("Confirmar");
        ebs_jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jBtnConfirmarActionPerformed(evt);
            }
        });

        ebs_jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar2.png"))); // NOI18N
        ebs_jBtnCancelar.setText("Cancelar");
        ebs_jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jBtnCancelarActionPerformed(evt);
            }
        });

        ebs_jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisa1.png"))); // NOI18N
        ebs_jBtnPesquisar.setText("Pesquisar");
        ebs_jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jBtnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ebs_jBtnIncluir)
                        .addGap(18, 18, 18)
                        .addComponent(ebs_jBtnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(ebs_jBtnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(ebs_jBtnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(ebs_jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(ebs_jBtnPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ebs_jTxtnome)
                            .addComponent(ebs_jTxtresponsavel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_jTxtid_transportadora, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ebs_jLblid_transportadora))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_JLblcnpj)
                                    .addComponent(ebs_jFmtcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ebs_jLblemail)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(ebs_jTxtemail))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_jFmttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ebs_jLbltelefone)))
                            .addComponent(ebs_jTxtendereco)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_jLblresponsavel)
                                    .addComponent(ebs_jLblnome)
                                    .addComponent(ebs_jLblendereco))
                                .addGap(0, 602, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ebs_jLblid_transportadora)
                    .addComponent(ebs_JLblcnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ebs_jTxtid_transportadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ebs_jFmtcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ebs_jLblnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ebs_jTxtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ebs_jLblresponsavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ebs_jTxtresponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ebs_jLblemail)
                            .addComponent(ebs_jLbltelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ebs_jTxtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ebs_jFmttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ebs_jLblendereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ebs_jTxtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ebs_jBtnIncluir)
                    .addComponent(ebs_jBtnConfirmar)
                    .addComponent(ebs_jBtnAlterar)
                    .addComponent(ebs_jBtnExcluir)
                    .addComponent(ebs_jBtnCancelar)
                    .addComponent(ebs_jBtnPesquisar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ebs_jTxtid_transportadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jTxtid_transportadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ebs_jTxtid_transportadoraActionPerformed

    private void ebs_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnIncluirActionPerformed
        habilitar(true);
        limparCampos();
        incluir = true;
    }//GEN-LAST:event_ebs_jBtnIncluirActionPerformed

    private void ebs_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnAlterarActionPerformed
        if (pesquisar == false) {
            String resp = JOptionPane.showInputDialog(null, "Entre com o codigo");
            Ebs_transportadoraDAO transportadoraDAO = new Ebs_transportadoraDAO();
            beanPview((Ebs_Transportadora) transportadoraDAO.list(Integer.parseInt(resp)));
        }
        habilitar(true);
        ebs_jTxtid_transportadora.setEnabled(false);
        incluir = false;
        pesquisar = false;
    }//GEN-LAST:event_ebs_jBtnAlterarActionPerformed

    private void ebs_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnExcluirActionPerformed
        if (pesquisar == false) {
            String resp = JOptionPane.showInputDialog(null, "Entre com o codigo");
            Ebs_transportadoraDAO transportadoraDAO = new Ebs_transportadoraDAO();
            beanPview((Ebs_Transportadora) transportadoraDAO.list(Integer.parseInt(resp)));
        }
        int resp = JOptionPane.showConfirmDialog(null, "Confirme exclusão!", "Deletar registro", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            Ebs_Transportadora transportadora = viewPbean();
            Ebs_transportadoraDAO transportadoraDAO = new Ebs_transportadoraDAO();
            transportadoraDAO.delete(transportadora);
            JOptionPane.showMessageDialog(null, "Exclusão realizada");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
            habilitar(false);
            limparCampos();
        }
        pesquisar = false;
    }//GEN-LAST:event_ebs_jBtnExcluirActionPerformed

    private void ebs_jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnConfirmarActionPerformed
        if (incluir == true) {
            Ebs_Transportadora transportadora = viewPbean();
            Ebs_transportadoraDAO transportadoraDAO = new Ebs_transportadoraDAO();
            transportadoraDAO.insert(transportadora);
        } else {
            Ebs_Transportadora transportadora = viewPbean();
            Ebs_transportadoraDAO transportadoraDAO = new Ebs_transportadoraDAO();
            transportadoraDAO.update(transportadora);
        }
        habilitar(false);
    }//GEN-LAST:event_ebs_jBtnConfirmarActionPerformed

    private void ebs_jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnCancelarActionPerformed
        habilitar(false);
        limparCampos();
    }//GEN-LAST:event_ebs_jBtnCancelarActionPerformed

    private void ebs_jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnPesquisarActionPerformed
        pesquisar = true;
        String resp = JOptionPane.showInputDialog(null, "Entre com o codigo");
        Ebs_transportadoraDAO transportadoraDAO = new Ebs_transportadoraDAO();
        beanPview((Ebs_Transportadora) transportadoraDAO.list(Integer.parseInt(resp)));
    }//GEN-LAST:event_ebs_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgTransportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgTransportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgTransportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgTransportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDlgTransportadora dialog = new JDlgTransportadora(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ebs_JLblcnpj;
    private javax.swing.JButton ebs_jBtnAlterar;
    private javax.swing.JButton ebs_jBtnCancelar;
    private javax.swing.JButton ebs_jBtnConfirmar;
    private javax.swing.JButton ebs_jBtnExcluir;
    private javax.swing.JButton ebs_jBtnIncluir;
    private javax.swing.JButton ebs_jBtnPesquisar;
    private javax.swing.JFormattedTextField ebs_jFmtcnpj;
    private javax.swing.JFormattedTextField ebs_jFmttelefone;
    private javax.swing.JLabel ebs_jLblemail;
    private javax.swing.JLabel ebs_jLblendereco;
    private javax.swing.JLabel ebs_jLblid_transportadora;
    private javax.swing.JLabel ebs_jLblnome;
    private javax.swing.JLabel ebs_jLblresponsavel;
    private javax.swing.JLabel ebs_jLbltelefone;
    private javax.swing.JTextField ebs_jTxtemail;
    private javax.swing.JTextField ebs_jTxtendereco;
    private javax.swing.JTextField ebs_jTxtid_transportadora;
    private javax.swing.JTextField ebs_jTxtnome;
    private javax.swing.JTextField ebs_jTxtresponsavel;
    // End of variables declaration//GEN-END:variables
}
