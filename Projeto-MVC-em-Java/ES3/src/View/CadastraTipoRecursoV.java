package View;

import ControlUC.TipoRecursoUC;
import javax.swing.JOptionPane;

public class CadastraTipoRecursoV extends javax.swing.JFrame {

    public CadastraTipoRecursoV() {
        initComponents();
        setLocation(430, 220);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btCadastrarTipoRecurso = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descrição");

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        jLabel2.setText("Observação");

        btCadastrarTipoRecurso.setText("Cadastrar");
        btCadastrarTipoRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarTipoRecursoActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrarTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSair)
                    .addComponent(btCadastrarTipoRecurso))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//cadastrar tipo de recurso
private void btCadastrarTipoRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarTipoRecursoActionPerformed
            try {
                String resultado;
                if (txtDescricao.getText().isEmpty()) {
                    throw new Exception("Campo Descrição Obrigatorio!");
                }
                if (txtObservacao.getText().isEmpty()) {
                    throw new Exception("Campo Observação Obrigatorio!");
                }
                TipoRecursoUC tRecUC = new TipoRecursoUC();
                resultado = tRecUC.cadastraTipoRecurso(txtDescricao.getText(), txtObservacao.getText());
                JOptionPane.showMessageDialog(null, resultado);
                if (resultado == "Tipo Recurso Cadastrado com Sucesso!") {
                    txtDescricao.setText("");
                    txtObservacao.setText("");
                } else {
                    txtDescricao.requestFocus();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

}//GEN-LAST:event_btCadastrarTipoRecursoActionPerformed

private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
    dispose();
    setVisible(false);
// TODO add your handling code here:
}//GEN-LAST:event_btSairActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrarTipoRecurso;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextArea txtObservacao;
    // End of variables declaration//GEN-END:variables
}
