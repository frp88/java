
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class principal extends javax.swing.JFrame {
    private Connection c = null;
    private PreparedStatement p = null;
   
    /** Creates new form principal */
    public principal() {
        initComponents();
        conecta();
        setLocation(200, 180);
        Sorteio();
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

 public void Sorteio(){
 SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
     Date DataAtual = new Date();
     String DataComp = "2008/11/26";
     String DataA = formato.format(DataAtual);
     if (DataComp.equals(DataA)){
         try {Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("Select idparticipante from tblparticipante" +
                " where amigo = "+0);
        if (rs.next()){
        rs = st.executeQuery("select max(idparticipante) as total from tblparticipante");
        if (rs.next()){
            int Total = rs.getInt("total");
            int i= 0;
            int ran = 0;
            int aux = 0;
            boolean valido = false;
            String sql = "";
            while (valido == false){   
               ran = 1 + (int) (Math.random() * Total);
               rs = st.executeQuery("select * from tblparticipante " +
                         "where idparticipante = "+ran);
              if (rs.next()){
                  valido = true;
                  aux = ran;
              }
            }
            boolean fim = false;
            while (fim == false){
                valido = false;
                while (valido == false){
                   ran = 1 + (int) (Math.random() * Total);
                   if (ran != aux){
                      rs = st.executeQuery("select * from tblparticipante " +
                         "where idparticipante = "+ran);
                      if (rs.next()){
                          rs = st.executeQuery("select * from tblparticipante " +
                          "where amigo = "+ran);
                          if (rs.next()){
                          }else{
                               sql = "update tblparticipante set " +
                                  "amigo  = ? where idparticipante = ?";       
                                  p=c.prepareStatement(sql);
                                  p.setInt(1, ran);
                                  p.setInt(2, aux);
                                  aux = ran;
                                  p.execute();
                                  valido = true;
                          aux = ran;
                         
                          }// fim da atualizaçao
                      }
                  }    
                }
                rs = st.executeQuery("select * from tblparticipante " +
                      "where amigo = "+0);
                if (rs.next()){
                   fim = false;
                }else{
                   fim = true;
                }   
            }    
           }
         JOptionPane.showMessageDialog(null, "Sorteio Realizado com Sucesso!!!");
         } 
       }catch(Exception e){
       } //a mais de testre        
    }
 }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AMIGO OCULTO");

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 0));

        jMenu1.setBackground(new java.awt.Color(255, 204, 0));
        jMenu1.setText("Cadastrar");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 102));
        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 1, 10));
        jMenuItem1.setText("Cadastro de Participantes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu4.setBackground(new java.awt.Color(255, 204, 0));
        jMenu4.setText("Alterar");
        jMenu4.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem2.setBackground(new java.awt.Color(255, 255, 102));
        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 1, 10));
        jMenuItem2.setText("Alterar Presentes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu2.setBackground(new java.awt.Color(255, 204, 0));
        jMenu2.setText("Pesquisar");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 102));
        jMenuItem3.setFont(new java.awt.Font("Times New Roman", 1, 10));
        jMenuItem3.setText("Pesquisar Sorteio");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(255, 204, 0));
        jMenu3.setText("Sair");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
 ///fdsafas   
}//GEN-LAST:event_jMenu3ActionPerformed

private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
    System.exit(0);// TODO add your handling code here:
}//GEN-LAST:event_jMenu3MouseClicked

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
   Date dtAtual = new Date();
   Date dtCompara =  new Date("2008/11/26"); 
   if (dtCompara.after(dtAtual)){    
      CadastroParticipantes frmcadparticipante = new CadastroParticipantes();
      frmcadparticipante.setVisible(true);
    }else{
      JOptionPane.showMessageDialog(null, "Cadastros Encerrados");
   }
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
  
}//GEN-LAST:event_jMenu4ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
   AlteraPresente TelaPresente = new AlteraPresente();
   TelaPresente.setVisible(true);
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jMenu1ActionPerformed

private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
  
    // TODO add your handling code here:
}//GEN-LAST:event_jMenu2ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
   Date dtAtual = new Date();
   Date dtCompara =  new Date("2008/11/26"); 
   if (dtCompara.before(dtAtual)){    
      PesquisaSorteio TelaPesquisa = new PesquisaSorteio();
      TelaPesquisa.setVisible(true);// TODO add your handling code here:
   }else{
      JOptionPane.showMessageDialog(null, "Sorteio ainda não realizado!!!");
   }  
   //PesquisaSorteio TelaPesquisa = new PesquisaSorteio();
   //TelaPesquisa.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables

}
