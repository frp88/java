
package PacotePetShop;

import java.sql.*;
import javax.swing.JOptionPane;

public class Agendamento extends javax.swing.JFrame {
     private Connection c = null;
     private PreparedStatement p = null;
     private int codigo = 0;

    /** Creates new form Agendamento */
    public Agendamento() {
        initComponents();
        conecta();
        setSize(420, 225);
        setLocation(400, 300);
        try{
        Statement st2 = c.createStatement();
        ResultSet rs2 = st2.executeQuery("select nome from animal order by nome asc");
        while (rs2.next()){
            cbNome.addItem(rs2.getString("nome"));
        }
        }catch (Exception e){
           JOptionPane.showMessageDialog(null,e.toString());
            
        }
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
public void Limpar(){
    cbHorario.setSelectedIndex(-1);
    editData.setText("");
 }    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbNome = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editData = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        btAgendar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cbHorario = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGENDAMENTO");
        getContentPane().setLayout(null);

        cbNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNomeItemStateChanged(evt);
            }
        });
        getContentPane().add(cbNome);
        cbNome.setBounds(70, 30, 330, 22);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setText("Ex: 2000/10/20");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 80, 90, 20);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel5.setText("Nome:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 30, 47, 18);

        try {
            editData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(editData);
        editData.setBounds(70, 80, 80, 21);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel6.setText("Hora:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(270, 80, 50, 18);

        btAgendar.setText("Agendar");
        btAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(btAgendar);
        btAgendar.setBounds(10, 150, 90, 23);

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btConsultar);
        btConsultar.setBounds(110, 150, 90, 23);

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir);
        btExcluir.setBounds(210, 150, 90, 23);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        getContentPane().add(btSair);
        btSair.setBounds(310, 150, 90, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 132, 420, 10);

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "09:00", "10:00", "11:00","14:00", "15:00", "16:00", "17:00" }));
        getContentPane().add(cbHorario);
        cbHorario.setBounds(320, 80, 80, 22);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel7.setText("Data:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 80, 39, 18);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNomeItemStateChanged
// TODO add your handling code here:
}//GEN-LAST:event_cbNomeItemStateChanged

private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
    desconecta();
    dispose();
    setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_btSairActionPerformed

private void btAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgendarActionPerformed
try {
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery("select idanimal, tamanho from animal "+
                "where nome = '"+cbNome.getSelectedItem().toString()+"'");
    if (rs.next()){// retorna codigo do animal
        int codigo = rs.getInt("idanimal");
        int tam = rs.getInt("tamanho");
        rs = st.executeQuery("select * from agenda " +
                " where idanimal = "+codigo+" and data = '"+editData.getText()+"' "+
                "and hora = '"+cbHorario.getSelectedItem().toString()+"'");
        if (rs.next()){
            JOptionPane.showMessageDialog(null,"Animal já agendado nesse horário!");
        }else{//inicio da consulta da quantidade de animais agendados por tamanho
            int peq = 0; int med = 0; int gran = 0;//variaveis para contar quantos animais ja estao agendados naquele horario
            rs = st.executeQuery("select count(idagenda) as quant from agenda inner join animal " +
                    " on agenda.idanimal = animal.idanimal "+
                    " where data = '"+editData.getText()+"' and hora = '"+cbHorario.getSelectedItem().toString()+"' "+
                    "and tamanho = 1");
            if (rs.next()){
                peq = rs.getInt("quant");
            }
            rs = st.executeQuery("select count(idagenda) as quant from agenda inner join animal " +
                    " on agenda.idanimal = animal.idanimal "+
                    " where data = '"+editData.getText()+"' and hora = '"+cbHorario.getSelectedItem().toString()+"' "+
                    "and tamanho = 2");
            if (rs.next()){
                med = rs.getInt("quant");
            }
            rs = st.executeQuery("select count(idagenda) as quant from agenda inner join animal " +
                    " on agenda.idanimal = animal.idanimal "+
                    " where data = '"+editData.getText()+"' and hora = '"+cbHorario.getSelectedItem().toString()+"' "+
                    "and tamanho = 3");
            if (rs.next()){
                gran = rs.getInt("quant");
            }//fim da consulta da quantidade de animais agendados por tamanho
            //Agendar no máximo 2 animais de porte grande no mesmo horários, ou 3 de porte médio, ou 3 de porte pequeno, 
            //ou 1 grande 2 pequenos, ou 1 grande e 1 médio, 1 médio e 2 pequenos, 2 médios e 1 pequeno.
            int total = (peq+med+gran);
            if (total < 3){
                if (total == 2){
                    if (gran == 2){
                        JOptionPane.showMessageDialog(null, "Não é possível agendar para esse horário!");
                    }else{
                        if ((gran == 1)&&(med==1)){
                            JOptionPane.showMessageDialog(null, "Não é possível agendar para esse horário!");
                        }else{
                            if (tam != 3){
                              //cadastrar
                              String sql = "insert into agenda " +
                              "(idanimal, Data, Hora) values (?,?,?)";       
                              p=c.prepareStatement(sql);
                              p.setInt(1, codigo);
                              p.setString(2, editData.getText());
                              p.setString(3, cbHorario.getSelectedItem().toString());
                              p.execute();
                              JOptionPane.showMessageDialog(null,"Agendamento realizado com sucesso!");
                              Limpar();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Não é possível agendar para esse horário!");
                        }
                     }
                  }
                }else{
                //cadastrar
                    String sql = "insert into agenda " +
                            "(idanimal, Data, Hora) values (?,?,?)";       
                            p=c.prepareStatement(sql);
                            p.setInt(1, codigo);
                            p.setString(2, editData.getText());
                            p.setString(3, cbHorario.getSelectedItem().toString());
                            p.execute();
                            JOptionPane.showMessageDialog(null,"Agendamento realizado com sucesso!");
                            Limpar();
                }
            }else{
              JOptionPane.showMessageDialog(null, "Não é possível agendar para esse horário!");
            }
        }
    }
   }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.toString());
   }
}//GEN-LAST:event_btAgendarActionPerformed

private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
 try{
     Statement st = c.createStatement();
     ResultSet rs = st.executeQuery("select nome, agenda.idanimal, data, hora from agenda inner join animal on " +
               " agenda.idanimal = animal.idanimal  "+
               " where nome = '"+cbNome.getSelectedItem().toString()+"' " +
               " order by data, hora");
     if (rs.next()){
        codigo = rs.getInt("agenda.idanimal");
        btExcluir.setEnabled(true);
        cbNome.setSelectedItem(rs.getString("nome"));
        editData.setText(rs.getString("data"));
        cbHorario.setSelectedItem(rs.getString("hora"));            
     }else{
        JOptionPane.showMessageDialog(null, "Animal não agendado!");
        Limpar();  
     }
  }catch(Exception e){
     JOptionPane.showMessageDialog(null,e.toString());
  }// TODO add your handling code here:
}//GEN-LAST:event_btConsultarActionPerformed

private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
try{
    int resp = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir esse agendamento?",
                 "Confirmar Exclusão",JOptionPane.YES_NO_OPTION);
    if (resp == 0){
        String sql = "delete from agenda " +
                     " where idanimal = ? and data = ? and hora = ?";
        p=c.prepareStatement(sql);
        p.setInt(1,codigo);
        p.setString(2, editData.getText());
        p.setString(3, cbHorario.getSelectedItem().toString());
        p.execute();
        JOptionPane.showMessageDialog(null, "Registro excluido!");  
        btExcluir.setEnabled(false);
        Limpar();
      }else{
        btExcluir.setEnabled(false);
        Limpar();
      }     
    }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.toString());
      }// TODO add your handling code here:
}//GEN-LAST:event_btExcluirActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgendar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox cbHorario;
    private javax.swing.JComboBox cbNome;
    private javax.swing.JFormattedTextField editData;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
