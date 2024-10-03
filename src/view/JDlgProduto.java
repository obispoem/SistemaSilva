/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import bean.Ebs_Produto;
import dao.Ebs_categoriaDAO;
import dao.Ebs_produtoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author bispo
 */
public class JDlgProduto extends javax.swing.JDialog {

    boolean incluir;
    boolean pesquisar;
    MaskFormatter maskDataChegada, maskDataValidade;

    /**
     * Creates new form jDlgUsuario
     */
    public JDlgProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Produto");
        setLocationRelativeTo(null);
        habilitar(false);

        Ebs_categoriaDAO categoriaDAO = new Ebs_categoriaDAO();
        categoriaDAO.listAll().forEach(categoria -> {
            ebs_jCbofk_categoria.addItem(categoria.getEbs_nome());
        });

        try {
            maskDataChegada = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ebs_jFmtdata_chegada.setFormatterFactory(new DefaultFormatterFactory(maskDataChegada));
        try {
            maskDataValidade = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ebs_jFmtdata_validade.setFormatterFactory(new DefaultFormatterFactory(maskDataValidade));

    }

    private void habilitar(boolean status) {
        // Habilitar ou desabilitar os campos de entrada
        ebs_jTxtid_produto.setEnabled(status);
        ebs_jCbofk_categoria.setEnabled(status);
        ebs_jTxtnome.setEnabled(status);
        ebs_jFmtdata_chegada.setEnabled(status);
        ebs_jFmtdata_validade.setEnabled(status);
        ebs_jTxtvalor.setEnabled(status);
        ebs_jTxtestoque.setEnabled(status);

        // Habilitar ou desabilitar botões
        ebs_jBtnIncluir.setEnabled(!status);
        ebs_jBtnAlterar.setEnabled(!status);
        ebs_jBtnPesquisar.setEnabled(!status);
        ebs_jBtnExcluir.setEnabled(!status);

        ebs_jBtnCancelar.setEnabled(status);
        ebs_jBtnConfirmar.setEnabled(status);

        // Limpar campos quando desabilitar
        if (!status) {
            limparCampos();
        }
    }

    private void limparCampos() {
        ebs_jTxtid_produto.setText("");
        ebs_jCbofk_categoria.setSelectedIndex(0);
        ebs_jTxtnome.setText("");
        ebs_jFmtdata_chegada.setText("");
        ebs_jFmtdata_validade.setText("");
        ebs_jTxtvalor.setText("");
        ebs_jTxtestoque.setText("");
    }

    public Ebs_Produto viewPbean() {
        Ebs_Produto produto = new Ebs_Produto();

        try {
            // Verificar se o campo ID do produto está vazio
            String idText = ebs_jTxtid_produto.getText();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O ID do produto não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Adiciona o id do produto na Classe
            produto.setEbs_id_produto(Integer.parseInt(idText));

            // Verificar se o nome do produto está vazio
            String nome = ebs_jTxtnome.getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome do produto não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Adiciona o nome do produto na Classe
            produto.setEbs_nome(nome);

            // Verificar se a categoria foi selecionada
            int categoriaSelecionada = ebs_jCbofk_categoria.getSelectedIndex();;
            if (categoriaSelecionada == 0) {
                JOptionPane.showMessageDialog(this, "Nenhuma categoria selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Adiciona a categoria do produto na Classe
            produto.setEbs_fk_categoria(ebs_jCbofk_categoria.getSelectedIndex());

            // Verificar se a data de chegada está vazia
            String dataChegadaText = ebs_jFmtdata_chegada.getText();
            if (dataChegadaText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A data de chegada não pode estar vazia", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Cria o formato de data e converte a data de chegada para a classe
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            produto.setEbs_data_chegada(new Date(dateFormat.parse(dataChegadaText).getTime()));

            // Verificar se a data de validade está vazia
            String dataValidadeText = ebs_jFmtdata_validade.getText();
            if (dataValidadeText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A data de validade não pode estar vazia", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Converte a data de validade para a classe
            produto.setEbs_data_validade(new Date(dateFormat.parse(dataValidadeText).getTime()));

            // Verificar se o valor está vazio
            String valorText = ebs_jTxtvalor.getText();
            if (valorText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O valor do produto não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Adiciona o valor do produto na Classe
            produto.setEbs_valor(Double.parseDouble(valorText));

            // Verificar se o estoque está vazio
            String estoqueText = ebs_jTxtestoque.getText();
            if (estoqueText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O estoque do produto não pode estar vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Adiciona o estoque do produto na Classe
            produto.setEbs_estoque(Integer.parseInt(estoqueText));

        } catch (NumberFormatException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao converter valores", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JDlgProduto.class.getName()).log(Level.SEVERE, "Erro ao preencher produto", ex);
            return null;
        }
        return produto;
    }

    // Método para preencher a interface gráfica com os valores do Bean Ebs_Produto
    public void beanPview(Ebs_Produto produto) {
        ebs_jTxtid_produto.setText(String.valueOf(produto.getEbs_id_produto()));
        ebs_jTxtnome.setText(produto.getEbs_nome());

        // Seleciona a categoria no ComboBox baseado no valor do Bean
        ebs_jCbofk_categoria.setSelectedIndex(produto.getEbs_fk_categoria());

        // Define o formato de data para exibição na interface
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ebs_jFmtdata_chegada.setText(dateFormat.format(produto.getEbs_data_chegada()));
        ebs_jFmtdata_validade.setText(dateFormat.format(produto.getEbs_data_validade()));

        ebs_jTxtvalor.setText(String.valueOf(produto.getEbs_valor()));
        ebs_jTxtestoque.setText(String.valueOf(produto.getEbs_estoque()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ebs_jLblCodigo = new javax.swing.JLabel();
        ebs_JLblCategoria = new javax.swing.JLabel();
        ebs_jLblNome = new javax.swing.JLabel();
        ebs_JLblDataChegada = new javax.swing.JLabel();
        ebs_JLblDataValidade = new javax.swing.JLabel();
        ebs_jLblValor = new javax.swing.JLabel();
        ebs_jLblEstoque = new javax.swing.JLabel();
        ebs_jTxtid_produto = new javax.swing.JTextField();
        ebs_jTxtnome = new javax.swing.JTextField();
        ebs_jFmtdata_chegada = new javax.swing.JFormattedTextField();
        ebs_jFmtdata_validade = new javax.swing.JFormattedTextField();
        ebs_jTxtvalor = new javax.swing.JTextField();
        ebs_jTxtestoque = new javax.swing.JTextField();
        ebs_jCbofk_categoria = new javax.swing.JComboBox<>();
        ebs_jBtnIncluir = new javax.swing.JButton();
        ebs_jBtnAlterar = new javax.swing.JButton();
        ebs_jBtnExcluir = new javax.swing.JButton();
        ebs_jBtnConfirmar = new javax.swing.JButton();
        ebs_jBtnCancelar = new javax.swing.JButton();
        ebs_jBtnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Dubai", 0, 12)); // NOI18N

        ebs_jLblCodigo.setText("ID");

        ebs_JLblCategoria.setText("Categoria");

        ebs_jLblNome.setText("Nome");

        ebs_JLblDataChegada.setText("Data de Chegada");

        ebs_JLblDataValidade.setText("Data de Validade");

        ebs_jLblValor.setText("Valor");

        ebs_jLblEstoque.setText("Estoque");

        ebs_jCbofk_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Definida" }));

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
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_JLblDataChegada)
                                    .addComponent(ebs_jFmtdata_chegada, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ebs_JLblDataValidade)
                                .addGap(136, 136, 136))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_jLblNome)
                                    .addComponent(ebs_jTxtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ebs_jFmtdata_validade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_jTxtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ebs_jLblValor))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ebs_jTxtestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ebs_jLblEstoque)))
                            .addComponent(ebs_jCbofk_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ebs_JLblCategoria)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ebs_jLblCodigo)
                            .addComponent(ebs_jTxtid_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(ebs_jBtnPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ebs_jLblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ebs_jTxtid_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ebs_jLblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ebs_jTxtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ebs_JLblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ebs_jCbofk_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ebs_JLblDataChegada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ebs_jFmtdata_chegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ebs_JLblDataValidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ebs_jFmtdata_validade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ebs_jLblValor)
                            .addComponent(ebs_jLblEstoque))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ebs_jTxtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ebs_jTxtestoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void ebs_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnIncluirActionPerformed
        habilitar(true);
        limparCampos();
        incluir = true;
    }//GEN-LAST:event_ebs_jBtnIncluirActionPerformed

    private void ebs_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnAlterarActionPerformed
        if (pesquisar == false) {
            String resp = JOptionPane.showInputDialog(null, "Entre com o codigo");
            Ebs_produtoDAO produtoDAO = new Ebs_produtoDAO();
            beanPview((Ebs_Produto) produtoDAO.list(Integer.parseInt(resp)));
        }
        habilitar(true);
        ebs_jTxtid_produto.setEnabled(false);
        incluir = false;
        pesquisar = false;
    }//GEN-LAST:event_ebs_jBtnAlterarActionPerformed

    private void ebs_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jBtnExcluirActionPerformed
        if (pesquisar == false) {
            String resp = JOptionPane.showInputDialog(null, "Entre com o codigo");
            Ebs_produtoDAO produtoDAO = new Ebs_produtoDAO();
            beanPview((Ebs_Produto) produtoDAO.list(Integer.parseInt(resp)));
        }
        int resp = JOptionPane.showConfirmDialog(null, "Confirme exclusão!", "Deletar registro", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            Ebs_Produto produto = viewPbean();
            Ebs_produtoDAO produtoDAO = new Ebs_produtoDAO();
            produtoDAO.delete(produto);
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
            Ebs_Produto produto = viewPbean();
            Ebs_produtoDAO produtoDAO = new Ebs_produtoDAO();
            produtoDAO.insert(produto);
        } else {
            Ebs_Produto produto = viewPbean();
            Ebs_produtoDAO produtoDAO = new Ebs_produtoDAO();
            produtoDAO.update(produto);
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
        Ebs_produtoDAO produtoDAO = new Ebs_produtoDAO();
        beanPview((Ebs_Produto) produtoDAO.list(Integer.parseInt(resp)));
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
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgProduto dialog = new JDlgProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ebs_JLblCategoria;
    private javax.swing.JLabel ebs_JLblDataChegada;
    private javax.swing.JLabel ebs_JLblDataValidade;
    private javax.swing.JButton ebs_jBtnAlterar;
    private javax.swing.JButton ebs_jBtnCancelar;
    private javax.swing.JButton ebs_jBtnConfirmar;
    private javax.swing.JButton ebs_jBtnExcluir;
    private javax.swing.JButton ebs_jBtnIncluir;
    private javax.swing.JButton ebs_jBtnPesquisar;
    private javax.swing.JComboBox<String> ebs_jCbofk_categoria;
    private javax.swing.JFormattedTextField ebs_jFmtdata_chegada;
    private javax.swing.JFormattedTextField ebs_jFmtdata_validade;
    private javax.swing.JLabel ebs_jLblCodigo;
    private javax.swing.JLabel ebs_jLblEstoque;
    private javax.swing.JLabel ebs_jLblNome;
    private javax.swing.JLabel ebs_jLblValor;
    private javax.swing.JTextField ebs_jTxtestoque;
    private javax.swing.JTextField ebs_jTxtid_produto;
    private javax.swing.JTextField ebs_jTxtnome;
    private javax.swing.JTextField ebs_jTxtvalor;
    // End of variables declaration//GEN-END:variables
}
