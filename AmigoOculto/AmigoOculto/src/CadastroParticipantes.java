import java.sql.*;
import javax.swing.JOptionPane;

public class CadastroParticipantes extends javax.swing.JFrame {
    
    private Connection c = null;
    private PreparedStatement p = null;
    /*private String url = "jdbc:mysql://localhost:3306/amigooculto,root,123456";/** Creates new form CadastroParticipantes */
    public CadastroParticipantes() {
        initComponents();
        conecta();
        setLocation(300, 250);
    }
public boolean conecta(){
       try{
          Class.forName("org.gjt.mm.mysql.Driver");
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/amigooculto","root","123456");
          return true;
       }catch(Exception e){
          System.err.print(e.toString()); 
          return false;
       }       
    }
 public void desconecta(){
       try{
          c.close(); 
        }catch(Exception e){
          System.err.print(e.toString());         
       }
    } 
public void Limpar(){
     editlogin.setText("");
     editnome.setText("");
     editpresentes.setText("");
     editsenha.setText("");
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editnome = new javax.swing.JTextField();
        btcancelar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btsalvar = new javax.swing.JButton();
        editlogin = new javax.swing.JTextField();
        editsenha = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        editpresentes = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE PARTICIPANTES");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setText("Senha:");

        btcancelar.setText("Cancelar");
        btcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarActionPerformed(evt);
            }
        });

        jButton7.setText("Sair");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Login:");

        btsalvar.setText("Salvar");
        btsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalvarActionPerformed(evt);
            }
        });

        editsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsenhaActionPerformed(evt);
            }
        });

        editpresentes.setColumns(20);
        editpresentes.setRows(5);
        jScrollPane1.setViewportView(editpresentes);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Lista de Presentes:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                            .add(editnome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(editlogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 153, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 177, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .add(162, 162, 162))
                            .add(layout.createSequentialGroup()
                                .add(editsenha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addContainerGap())))))
            .add(layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(btsalvar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(btcancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(editnome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(editlogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(editsenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btcancelar)
                    .add(btsalvar)
                    .add(jButton7))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    dispose();
    desconecta();
    setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton7ActionPerformed

private void btsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalvarActionPerformed
      String senha = new String(editsenha.getPassword());
      try {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select login From tblparticipante "+
                "where login = '"+editlogin.getText()+"'");
        if (rs.next()){
            JOptionPane.showMessageDialog(null, "Login já Cadastrado!!! \n Escolha outro Login.");
            editlogin.requestFocus(); 
        }else{
            String sql = "insert into tblparticipante " +
               "(nome, login, senha, presentes, amigo " +
               ") values (?,?,?,?,?)";       
       p=c.prepareStatement(sql);
       p.setString(1, editnome.getText());
       p.setString(2, editlogin.getText());
       p.setString(3, senha);
       p.setString(4, editpresentes.getText());
       p.setInt(5, 0);
       p.execute();
       JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
       Limpar();
       editnome.requestFocus(); 
        }
      }catch(Exception e){
          
      }

}//GEN-LAST:event_btsalvarActionPerformed

private void editsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsenhaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_editsenhaActionPerformed

private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
   Limpar();
   editnome.requestFocus(); 
}//GEN-LAST:event_btcancelarActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroParticipantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton btsalvar;
    private javax.swing.JTextField editlogin;
    private javax.swing.JTextField editnome;
    private javax.swing.JTextArea editpresentes;
    private javax.swing.JPasswordField editsenha;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
