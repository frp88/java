package View;

import ControlUC.RecursoUC;
import ControlUC.TipoRecursoUC;
import java.sql.*;
import javax.swing.JOptionPane;
import DAO.TipoRecursoDAO;
import Banco.ConexaoBanco;
import java.sql.*;
import ModelBO.TipoRecursoBO;

public class CadastraRecursoV extends javax.swing.JFrame {

    public CadastraRecursoV() {
        initComponents();
        setLocation(430, 220);
        try {
            TipoRecursoUC tipoRecUC = new TipoRecursoUC();
            ResultSet rs = tipoRecUC.pegaTipoRecurso();
            cbTipoRecurso.removeAllItems();
            cbTipoRecurso.addItem("SELECIONE UM TIPO DE RECURSO");

            while (rs.next()) {
                cbTipoRecurso.addItem(rs.getString("sDescricao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btCadastrarRecurso = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbTipoRecurso = new javax.swing.JComboBox();
        cbLocalizacao = new javax.swing.JComboBox();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Descrição");

        jLabel2.setText("Localização");

        btCadastrarRecurso.setText("Cadastrar");
        btCadastrarRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarRecursoActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de Recurso");

        cbTipoRecurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE UM TIPO DE RECURSO" }));
        cbTipoRecurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoRecursoItemStateChanged(evt);
            }
        });
        cbTipoRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoRecursoActionPerformed(evt);
            }
        });

        cbLocalizacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE UMA LOCALIZAÇÃO", "PREDIO PRINCIPAL", "BIBLIOTECA", "BLOCO 2", "BLOCO 6", "BLOCO 9", "BLOCO 13", "D A", "FAZENDA" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLocalizacao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbTipoRecurso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btCadastrarRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrarRecurso)
                    .addComponent(btSair))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btCadastrarRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarRecursoActionPerformed
    try {
        String resultado = "";
        if (cbTipoRecurso.getSelectedIndex() == 0) {
            throw new Exception("    Tipo Recurso Obrigatório!\n Selecione um Tipo de Recurso.");
        }
        if (cbLocalizacao.getSelectedIndex() == 0) {
            throw new Exception("   Localização Obrigatória!\n Selecione uma Localização.");
        }
        if (txtDescricao.getText().isEmpty()) {
            throw new Exception("Campo Descrição Obrigatorio!");
        }
        RecursoUC recUC = new RecursoUC();
        resultado = recUC.cadastraRecurso(cbTipoRecurso.getSelectedItem().toString(), txtDescricao.getText(), cbLocalizacao.getSelectedItem().toString());
        if (resultado == "Recurso Cadastrado com Sucesso!") {
            txtDescricao.setText("");
            cbTipoRecurso.setSelectedIndex(0);
            cbLocalizacao.setSelectedIndex(0);
        } else {
            txtDescricao.requestFocus();
        }
        JOptionPane.showMessageDialog(null, resultado);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }// TODO add your handling code here:
}//GEN-LAST:event_btCadastrarRecursoActionPerformed

private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
    dispose();
    setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_btSairActionPerformed

private void cbTipoRecursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoRecursoItemStateChanged
  txtDescricao.setText(cbTipoRecurso.getSelectedItem()  == null || cbTipoRecurso.getSelectedIndex() == 0 ? "" : cbTipoRecurso.getSelectedItem().toString());// TODO add your handling code here:
}//GEN-LAST:event_cbTipoRecursoItemStateChanged

private void cbTipoRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoRecursoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbTipoRecursoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrarRecurso;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox cbLocalizacao;
    private javax.swing.JComboBox cbTipoRecurso;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
