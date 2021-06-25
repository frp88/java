package View;

import javax.swing.JOptionPane;
import ModelBO.TipoUsuario;
import ControlUC.UsuarioUC;

public class PrincipalV extends javax.swing.JFrame {

    LoginV frmLogin = null;

    /** Creates new form PrincipalV */
    public PrincipalV(LoginV l) {
        frmLogin = l;
        initComponents();
        setSize(800, 500);
        setLocation(250, 150);
        UsuarioUC userUC = new UsuarioUC();

        switch (userUC.tUsuario) {
            case 0:// Master

                menuCadastros.setVisible(true);
                menuAgendamentos.setVisible(true);
                menuMovimentacao.setVisible(true);

                menuCadastrarRecurso.setVisible(true);
                menuCadastrarTipoRecurso.setVisible(true);
                menuCadastroUsuario.setVisible(true);
                break;
            case 1://Gerente almorafixe

                menuCadastros.setVisible(true);
                menuAgendamentos.setVisible(false);
                menuMovimentacao.setVisible(false);

                menuCadastrarRecurso.setVisible(true);
                menuCadastrarTipoRecurso.setVisible(true);
                menuCadastroUsuario.setVisible(false);
                break;
            case 2://Auxiliar de Almoxarife

                menuCadastros.setVisible(false);
                menuAgendamentos.setVisible(false);
                menuMovimentacao.setVisible(true);

                menuCadastrarRecurso.setVisible(false);
                menuCadastrarTipoRecurso.setVisible(false);
                menuCadastroUsuario.setVisible(false);
                break;
            case 3://Funcionario do RH

                menuCadastros.setVisible(true);
                menuAgendamentos.setVisible(false);
                menuMovimentacao.setVisible(false);

                menuCadastrarRecurso.setVisible(false);
                menuCadastrarTipoRecurso.setVisible(false);
                menuCadastroUsuario.setVisible(true);
                break;
            case 4://Professor

                menuCadastros.setVisible(false);
                menuAgendamentos.setVisible(true);
                menuMovimentacao.setVisible(false);

                menuCadastrarRecurso.setVisible(false);
                menuCadastrarTipoRecurso.setVisible(false);
                menuCadastroUsuario.setVisible(false);
                break;
            default:
                menuCadastros.setVisible(false);
                menuAgendamentos.setVisible(false);
                menuMovimentacao.setVisible(false);

                menuCadastrarRecurso.setVisible(false);
                menuCadastrarTipoRecurso.setVisible(false);
                menuCadastroUsuario.setVisible(false);

                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuCadastrarRecurso = new javax.swing.JMenuItem();
        menuCadastrarTipoRecurso = new javax.swing.JMenuItem();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        menuAgendamentos = new javax.swing.JMenu();
        menuCadastrarAgendamento = new javax.swing.JMenuItem();
        menuCancelarAgendamento = new javax.swing.JMenuItem();
        menuMovimentacao = new javax.swing.JMenu();
        menuEntregaRecurso = new javax.swing.JMenuItem();
        menuRecolheRecurso = new javax.swing.JMenuItem();
        menuLogoff = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastros.setText("Cadastros");

        menuCadastrarRecurso.setText("Recurso");
        menuCadastrarRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarRecursoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadastrarRecurso);

        menuCadastrarTipoRecurso.setText("Tipo Recurso");
        menuCadastrarTipoRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarTipoRecursoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadastrarTipoRecurso);

        menuCadastroUsuario.setText("Usuário");
        menuCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroUsuarioActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadastroUsuario);

        jMenuBar1.add(menuCadastros);

        menuAgendamentos.setText("Agendamentos");

        menuCadastrarAgendamento.setText("Novo Agendamento");
        menuCadastrarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarAgendamentoActionPerformed(evt);
            }
        });
        menuAgendamentos.add(menuCadastrarAgendamento);

        menuCancelarAgendamento.setText("Cancelar Agendamento");
        menuAgendamentos.add(menuCancelarAgendamento);

        jMenuBar1.add(menuAgendamentos);

        menuMovimentacao.setText("Movimentação");

        menuEntregaRecurso.setText("Entrega Recurso");
        menuMovimentacao.add(menuEntregaRecurso);

        menuRecolheRecurso.setText("Recolhe Recurso");
        menuMovimentacao.add(menuRecolheRecurso);

        jMenuBar1.add(menuMovimentacao);

        menuLogoff.setText("Logoff");
        menuLogoff.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                menuLogoffStateChanged(evt);
            }
        });
        jMenuBar1.add(menuLogoff);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                menuSairStateChanged(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void menuCadastrarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarAgendamentoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_menuCadastrarAgendamentoActionPerformed

private void menuCadastrarTipoRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarTipoRecursoActionPerformed
    CadastraTipoRecursoV frmCadastraTipoRecurso = new CadastraTipoRecursoV();
    frmCadastraTipoRecurso.setVisible(true);
}//GEN-LAST:event_menuCadastrarTipoRecursoActionPerformed

private void menuCadastrarRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarRecursoActionPerformed
    CadastraRecursoV frmCadastraRecurso = new CadastraRecursoV();
    frmCadastraRecurso.setVisible(true);
// TODO add your handling code here:
}//GEN-LAST:event_menuCadastrarRecursoActionPerformed

private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_menuSairActionPerformed

private void menuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioActionPerformed
    CadastraUsuarioV frmCadastraUsuario = new CadastraUsuarioV();
    frmCadastraUsuario.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_menuCadastroUsuarioActionPerformed

private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
    // JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA !!!");
    //System.exit(0);// TODO add your handling code here:
}//GEN-LAST:event_menuSairMouseClicked

private void menuSairStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuSairStateChanged
    JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA !!!");
    System.exit(0);/// TODO add your handling code here:
}//GEN-LAST:event_menuSairStateChanged

private void menuLogoffStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuLogoffStateChanged
    setVisible(false);
    dispose();
    frmLogin.txtLogin.setText("");
    frmLogin.txtSenha.setText("");
    frmLogin.setVisible(true);
}//GEN-LAST:event_menuLogoffStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAgendamentos;
    private javax.swing.JMenuItem menuCadastrarAgendamento;
    private javax.swing.JMenuItem menuCadastrarRecurso;
    private javax.swing.JMenuItem menuCadastrarTipoRecurso;
    private javax.swing.JMenuItem menuCadastroUsuario;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuCancelarAgendamento;
    private javax.swing.JMenuItem menuEntregaRecurso;
    private javax.swing.JMenu menuLogoff;
    private javax.swing.JMenu menuMovimentacao;
    private javax.swing.JMenuItem menuRecolheRecurso;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
