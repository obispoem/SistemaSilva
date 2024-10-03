package view;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme;
import dao.DAO_Abstract;

public class JFrmPrincipal extends javax.swing.JFrame {

    String banco;

    public JFrmPrincipal() {
        initComponents();
        setTitle("Sistema Vinhos");
        setExtendedState(MAXIMIZED_BOTH);
        jChbMnuBancoLocal.setSelected(false);
        jChbMnuBancoIF.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblFundo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMnuCadastros = new javax.swing.JMenu();
        ebs_jMnuProduto = new javax.swing.JMenuItem();
        ebs_jMnuCategoria = new javax.swing.JMenuItem();
        ebs_jMnuFornecedor = new javax.swing.JMenuItem();
        ebs_jMnuTransportadora = new javax.swing.JMenuItem();
        ebs_jMnuUsuario = new javax.swing.JMenuItem();
        ebs_JSeparator = new javax.swing.JPopupMenu.Separator();
        ebs_jMnuSair = new javax.swing.JMenuItem();
        jMnuMovimentos = new javax.swing.JMenu();
        jMnuCompra = new javax.swing.JMenuItem();
        jMnuCompraProduto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jChbMnuBancoLocal = new javax.swing.JCheckBoxMenuItem();
        jChbMnuBancoIF = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblFundo.setBackground(new java.awt.Color(204, 255, 0));
        jLblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vinho_fundo3.jpg"))); // NOI18N

        jMnuCadastros.setMnemonic('C');
        jMnuCadastros.setText("Cadastros");

        ebs_jMnuProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ebs_jMnuProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/produto.png"))); // NOI18N
        ebs_jMnuProduto.setText("Produto");
        ebs_jMnuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jMnuProdutoActionPerformed(evt);
            }
        });
        jMnuCadastros.add(ebs_jMnuProduto);

        ebs_jMnuCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        ebs_jMnuCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categoria.png"))); // NOI18N
        ebs_jMnuCategoria.setText("Categoria");
        ebs_jMnuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jMnuCategoriaActionPerformed(evt);
            }
        });
        jMnuCadastros.add(ebs_jMnuCategoria);

        ebs_jMnuFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ebs_jMnuFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fornecedor.png"))); // NOI18N
        ebs_jMnuFornecedor.setText("Fornecedor");
        ebs_jMnuFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jMnuFornecedorActionPerformed(evt);
            }
        });
        jMnuCadastros.add(ebs_jMnuFornecedor);

        ebs_jMnuTransportadora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ebs_jMnuTransportadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transporte.png"))); // NOI18N
        ebs_jMnuTransportadora.setText("Transportadora");
        ebs_jMnuTransportadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jMnuTransportadoraActionPerformed(evt);
            }
        });
        jMnuCadastros.add(ebs_jMnuTransportadora);

        ebs_jMnuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ebs_jMnuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario1.png"))); // NOI18N
        ebs_jMnuUsuario.setText("Usuario");
        ebs_jMnuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jMnuUsuarioActionPerformed(evt);
            }
        });
        jMnuCadastros.add(ebs_jMnuUsuario);
        jMnuCadastros.add(ebs_JSeparator);

        ebs_jMnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ebs_jMnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        ebs_jMnuSair.setText("Sair");
        ebs_jMnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebs_jMnuSairActionPerformed(evt);
            }
        });
        jMnuCadastros.add(ebs_jMnuSair);

        jMenuBar.add(jMnuCadastros);

        jMnuMovimentos.setMnemonic('M');
        jMnuMovimentos.setText("Movimentos");

        jMnuCompra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMnuCompra.setText("Compra");
        jMnuCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuCompraActionPerformed(evt);
            }
        });
        jMnuMovimentos.add(jMnuCompra);

        jMnuCompraProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMnuCompraProduto.setText("Compra Produto");
        jMnuMovimentos.add(jMnuCompraProduto);

        jMenuBar.add(jMnuMovimentos);

        jMenu1.setText("Banco");

        jChbMnuBancoLocal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jChbMnuBancoLocal.setSelected(true);
        jChbMnuBancoLocal.setText("Banco Local");
        jChbMnuBancoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbMnuBancoLocalActionPerformed(evt);
            }
        });
        jMenu1.add(jChbMnuBancoLocal);

        jChbMnuBancoIF.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jChbMnuBancoIF.setSelected(true);
        jChbMnuBancoIF.setText("Banco IF");
        jChbMnuBancoIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbMnuBancoIFActionPerformed(evt);
            }
        });
        jMenu1.add(jChbMnuBancoIF);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 543, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ebs_jMnuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jMnuUsuarioActionPerformed
        JDlgUsuario jDlgU = new JDlgUsuario(null, true);
        jDlgU.setVisible(true);
    }//GEN-LAST:event_ebs_jMnuUsuarioActionPerformed

    private void ebs_jMnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jMnuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ebs_jMnuSairActionPerformed

    private void ebs_jMnuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jMnuProdutoActionPerformed
        JDlgProduto jDlgP = new JDlgProduto(null, true);
        jDlgP.setVisible(true);
    }//GEN-LAST:event_ebs_jMnuProdutoActionPerformed

    private void ebs_jMnuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jMnuCategoriaActionPerformed
        JDlgCategoria jDlgC = new JDlgCategoria(null, true);
        jDlgC.setVisible(true);
    }//GEN-LAST:event_ebs_jMnuCategoriaActionPerformed

    private void ebs_jMnuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jMnuFornecedorActionPerformed
        JDlgFornecedor jDlgF = new JDlgFornecedor(null, true);
        jDlgF.setVisible(true);
    }//GEN-LAST:event_ebs_jMnuFornecedorActionPerformed

    private void ebs_jMnuTransportadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebs_jMnuTransportadoraActionPerformed
        JDlgTransportadora jDlgT = new JDlgTransportadora(null, true);
        jDlgT.setVisible(true);
    }//GEN-LAST:event_ebs_jMnuTransportadoraActionPerformed

    private void jChbMnuBancoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbMnuBancoLocalActionPerformed
        // TODO add your handling code here:
        if (jChbMnuBancoLocal.isSelected()) {
            jChbMnuBancoIF.setSelected(false);
            jChbMnuBancoLocal.setSelected(true);
        }
        banco = "local";
        DAO_Abstract.setBanco(banco);
    }//GEN-LAST:event_jChbMnuBancoLocalActionPerformed

    private void jChbMnuBancoIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbMnuBancoIFActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (jChbMnuBancoIF.isSelected()) {
            jChbMnuBancoLocal.setSelected(false);
            jChbMnuBancoIF.setSelected(true);
        }
        banco = "if";
        DAO_Abstract.setBanco(banco);
    }//GEN-LAST:event_jChbMnuBancoIFActionPerformed

    private void jMnuCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuCompraActionPerformed
        
    }//GEN-LAST:event_jMnuCompraActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            FlatSolarizedDarkIJTheme.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new JFrmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator ebs_JSeparator;
    private javax.swing.JMenuItem ebs_jMnuCategoria;
    private javax.swing.JMenuItem ebs_jMnuFornecedor;
    private javax.swing.JMenuItem ebs_jMnuProduto;
    private javax.swing.JMenuItem ebs_jMnuSair;
    private javax.swing.JMenuItem ebs_jMnuTransportadora;
    private javax.swing.JMenuItem ebs_jMnuUsuario;
    private javax.swing.JCheckBoxMenuItem jChbMnuBancoIF;
    private javax.swing.JCheckBoxMenuItem jChbMnuBancoLocal;
    private javax.swing.JLabel jLblFundo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMnuCadastros;
    private javax.swing.JMenuItem jMnuCompra;
    private javax.swing.JMenuItem jMnuCompraProduto;
    private javax.swing.JMenu jMnuMovimentos;
    // End of variables declaration//GEN-END:variables
}
