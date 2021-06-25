import java.sql.*;
import javax.swing.JOptionPane;

public class AlteraPresente extends javax.swing.JFrame {
    
    private Connection c = null;
    private PreparedStatement p = null;
   
    public AlteraPresente() {
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
      editpresentes.setText("");
      editsenha.setText("");
 }
     public void Sair(){
       dispose();
       desconecta();
       setVisible(false);   
     }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        editlogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        editsenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editpresentes = new javax.swing.JTextArea();
        btalterar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        btsair = new javax.swing.JButton();
        btok = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALTERAR PRESENTE");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Login:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setText("Senha:");

        editsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsenhaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Lista de Presentes:");

        editpresentes.setColumns(20);
        editpresentes.setRows(5);
        jScrollPane1.setViewportView(editpresentes);

        btalterar.setText("Alterar");
        btalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btalterarActionPerformed(evt);
            }
        });

        btcancelar.setText("Cancelar");
        btcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarActionPerformed(evt);
            }
        });

        btsair.setText("Sair");
        btsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsairActionPerformed(evt);
            }
        });

        btok.setText("Ver Lista de Presentes");
        btok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btokActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(editlogin, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 177, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(editsenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .add(192, 192, 192))
            .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(41, 41, 41)
                .add(btok, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 355, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 415, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(btalterar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(btcancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(btsair, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(editlogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(editsenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(btok)
                .add(13, 13, 13)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btsair)
                    .add(btcancelar)
                    .add(btalterar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void editsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsenhaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_editsenhaActionPerformed

private void btalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btalterarActionPerformed
    String senha = new String(editsenha.getPassword());
      try {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select login From tblparticipante "+
                "where login = '"+editlogin.getText()+"'");
        if (rs.next()){
            String sql = "update tblparticipante set " +
                         "presentes  = ? where login = ?";       
            p=c.prepareStatement(sql);
            p.setString(1, editpresentes.getText());
            p.setString(2, editlogin.getText());
            p.execute();
            JOptionPane.showMessageDialog(null,"Presentes Alterados!");
            Limpar();
            Sair();
        }else{
                 
      }
      }catch(Exception e){
          
      }
}//GEN-LAST:event_btalterarActionPerformed

private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
   Limpar();
   editlogin.requestFocus();  
}//GEN-LAST:event_btcancelarActionPerformed

private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed
    Sair();// TODO add your handling code here:
}//GEN-LAST:event_btsairActionPerformed

private void btokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btokActionPerformed
    String senha = new String(editsenha.getPassword());
    try {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select login, senha, presentes from tblparticipante "+
                "where login = '"+editlogin.getText()+"'and (senha = '"+senha+"')");
        if (rs.next()){
            editpresentes.setText(rs.getString("presentes"));
           }else{
          JOptionPane.showMessageDialog(null, "Login ou Senha Invalidos!");
          editlogin.setText("");
          editsenha.setText("");
          editlogin.requestFocus();  
        }
      }catch(Exception e){
          
      }// TODO add your handling code here:
}//GEN-LAST:event_btokActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraPresente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btalterar;
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton btok;
    private javax.swing.JButton btsair;
    private javax.swing.JTextField editlogin;
    private javax.swing.JTextArea editpresentes;
    private javax.swing.JPasswordField editsenha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
