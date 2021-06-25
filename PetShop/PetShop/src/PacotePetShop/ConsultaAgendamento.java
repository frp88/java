
package PacotePetShop;

import java.sql.*;
import java.util.Date.*;
import javax.swing.JOptionPane;


public class ConsultaAgendamento extends javax.swing.JFrame {
    private Connection c = null;
    private PreparedStatement p = null;
    private int codigo = 0;

    /** Creates new form ConsultaAgendamento */
    public ConsultaAgendamento() {
        initComponents();
        conecta();
        setSize(468, 495);
        setLocation(350, 200); 
      
    }
public boolean conecta(){
       try{
          Class.forName("org.gjt.mm.mysql.Driver");
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop","root","123456");
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
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        editDataIni = new javax.swing.JFormattedTextField();
        editDataFim = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btConsultar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Memo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTA AGENDAMENTO");
        getContentPane().setLayout(null);

        try {
            editDataIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(editDataIni);
        editDataIni.setBounds(10, 30, 100, 21);

        try {
            editDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(editDataFim);
        editDataFim.setBounds(250, 30, 100, 21);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel2.setText("Animais agendados nesse periodo:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 140, 350, 18);

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btConsultar);
        btConsultar.setBounds(10, 90, 210, 23);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        getContentPane().add(btSair);
        btSair.setBounds(250, 90, 200, 23);

        Memo.setColumns(20);
        Memo.setRows(5);
        jScrollPane1.setViewportView(Memo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 440, 290);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel3.setText("Data Final:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 10, 100, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 70, 460, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 130, 460, 10);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel5.setText("Data Inicial:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 10, 100, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setText("Ex: 2000/10/20");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 30, 100, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Ex: 2000/10/20");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 30, 100, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
    try{
        Memo.setText("");
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select agenda.idanimal, nome, data, hora from agenda inner join animal " +
                " on agenda.idanimal = animal.idanimal " +
                " where agenda.data >= '"+editDataIni.getText()+"' and agenda.data <= '"+editDataFim.getText()+"' " +
                "  order by data, hora");
        String consut = "";
        boolean existe = false;
        while (rs.next()){
            existe = true;
            consut+= rs.getString("agenda.idanimal")+" - "+rs.getString("nome")+" - "+rs.getString("data")+" - "+rs.getString("hora")+"\n";
        }
        Memo.setText(consut);
        if (existe == false){
            JOptionPane.showMessageDialog(null,"Nenhum animal agendado entre "+editDataIni.getText()+" e "+editDataFim.getText()+"!");
            editDataIni.setText("");
            editDataFim.setText("");
           }
    }catch (Exception e){
        JOptionPane.showMessageDialog(null,e.toString());
    }
}//GEN-LAST:event_btConsultarActionPerformed

private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
    desconecta();
    dispose();
    setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_btSairActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Memo;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btSair;
    private javax.swing.JFormattedTextField editDataFim;
    private javax.swing.JFormattedTextField editDataIni;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
