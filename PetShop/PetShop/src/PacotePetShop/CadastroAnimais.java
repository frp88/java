
package PacotePetShop;

import java.sql.*;
import javax.swing.JOptionPane;
public class CadastroAnimais extends javax.swing.JFrame {
    private Connection c = null;
    private PreparedStatement p = null;
    private int codigo = 0;

    /** Creates new form CadastroAnimais */
    public CadastroAnimais() {
        initComponents();
        conecta();
        setSize(620, 400);
        setLocation(270, 250);
      
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
     editnome.setText("");
     editdono.setText("");
     editbairro.setText("");
     editcidade.setText("");
     editdtnasc.setText("");
     editnum.setText("");
     edittel.setText("");
     editemail.setText("");
     editrua.setText("");
     comboboxestado.setSelectedIndex(-1);
     comboboxtam.setSelectedIndex(-1);
     btAlterar.setEnabled(false);
     btExcluir.setEnabled(false);
     btcadastrar.setEnabled(true);
     editnome.requestFocus();
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btcadastrar = new javax.swing.JButton();
        btcancela = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btsair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboboxtam = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        editnome = new javax.swing.JTextField();
        editdono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        editrua = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        editbairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        editcidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        edittel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        editemail = new javax.swing.JTextField();
        comboboxestado = new javax.swing.JComboBox();
        editdtnasc = new javax.swing.JFormattedTextField();
        btbuscar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE ANIMAIS");
        getContentPane().setLayout(null);

        btcadastrar.setText("Cadastrar");
        btcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btcadastrar);
        btcadastrar.setBounds(10, 320, 92, 23);

        btcancela.setText("Cancelar");
        btcancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelaActionPerformed(evt);
            }
        });
        getContentPane().add(btcancela);
        btcancela.setBounds(310, 320, 92, 23);

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir);
        btExcluir.setBounds(410, 320, 92, 23);

        btsair.setText("Sair");
        btsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsairActionPerformed(evt);
            }
        });
        getContentPane().add(btsair);
        btsair.setBounds(510, 320, 92, 23);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel1.setText("E-mail:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 260, 60, 18);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel2.setText("Tamanho:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 70, 90, 18);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel3.setText("Data Nascimento:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 70, 132, 18);

        comboboxtam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pequeno", "Médio", "Grande" }));
        comboboxtam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxtamItemStateChanged(evt);
            }
        });
        comboboxtam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxtamActionPerformed(evt);
            }
        });
        getContentPane().add(comboboxtam);
        comboboxtam.setBounds(450, 70, 140, 22);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel4.setText("Nome:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 30, 47, 18);
        getContentPane().add(editnome);
        editnome.setBounds(100, 30, 490, 19);
        getContentPane().add(editdono);
        editdono.setBounds(100, 110, 490, 19);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel5.setText("Dono:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 110, 42, 18);
        getContentPane().add(editrua);
        editrua.setBounds(100, 150, 350, 19);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel6.setText("Rua:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 150, 33, 18);

        editnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editnumActionPerformed(evt);
            }
        });
        getContentPane().add(editnum);
        editnum.setBounds(500, 150, 90, 19);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel7.setText("Nº:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(470, 150, 22, 18);
        getContentPane().add(editbairro);
        editbairro.setBounds(100, 180, 350, 19);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel8.setText("Bairro:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 180, 60, 18);

        editcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editcidadeActionPerformed(evt);
            }
        });
        getContentPane().add(editcidade);
        editcidade.setBounds(100, 220, 270, 19);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel9.setText("Cidade:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 220, 60, 18);

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(440, 220, 60, 18);
        getContentPane().add(edittel);
        edittel.setBounds(100, 260, 110, 19);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel11.setText("Telefone:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 260, 80, 20);
        getContentPane().add(editemail);
        editemail.setBounds(290, 260, 300, 19);

        comboboxestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA"
            , "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO"
            , "RR", "RS", "SC", "SE", "SP", "TO"}));
comboboxestado.addItemListener(new java.awt.event.ItemListener() {
    public void itemStateChanged(java.awt.event.ItemEvent evt) {
        comboboxestadoItemStateChanged(evt);
    }
    });
    getContentPane().add(comboboxestado);
    comboboxestado.setBounds(510, 220, 80, 22);

    try {
        editdtnasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
    getContentPane().add(editdtnasc);
    editdtnasc.setBounds(160, 70, 90, 21);

    btbuscar.setText("Buscar");
    btbuscar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btbuscarActionPerformed(evt);
        }
    });
    getContentPane().add(btbuscar);
    btbuscar.setBounds(110, 320, 92, 23);

    btAlterar.setText("Alterar");
    btAlterar.setEnabled(false);
    btAlterar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btAlterarActionPerformed(evt);
        }
    });
    getContentPane().add(btAlterar);
    btAlterar.setBounds(210, 320, 92, 23);

    jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12));
    getContentPane().add(jLabel12);
    jLabel12.setBounds(100, 20, 70, 0);
    getContentPane().add(jSeparator1);
    jSeparator1.setBounds(0, 300, 620, 10);

    jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
    jLabel13.setText("Ex: 20/10/2000");
    getContentPane().add(jLabel13);
    jLabel13.setBounds(260, 70, 100, 20);

    pack();
    }// </editor-fold>//GEN-END:initComponents

private void comboboxtamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxtamItemStateChanged
    // TODO add your handling code here:
}//GEN-LAST:event_comboboxtamItemStateChanged

private void comboboxtamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxtamActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_comboboxtamActionPerformed

private void editcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editcidadeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_editcidadeActionPerformed

private void editnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editnumActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_editnumActionPerformed

private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed
    dispose();
    setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_btsairActionPerformed

private void comboboxestadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxestadoItemStateChanged
// TODO add your handling code here:
}//GEN-LAST:event_comboboxestadoItemStateChanged

private void btcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcadastrarActionPerformed
    int tam = 0;
    if (comboboxtam.getSelectedItem().toString().equals("Pequeno")){
       tam = 1; 
    }else if (comboboxtam.getSelectedItem().toString().equals("Médio")){
       tam = 2; 
    }else if (comboboxtam.getSelectedItem().toString().equals("Grande")){
       tam = 3;    
    }
    try {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select nome From animal "+
                "where nome = '"+editnome.getText()+"'");
        if (rs.next()){
            JOptionPane.showMessageDialog(null, " Já existe um animal com esse nome cadastrado!\n" +
                                                "Coloque outro nome ou um sobrenome para o animal.");
            editnome.requestFocus();
         }else{
            String sql = "insert into animal " +
               "(nome, nomedono, rua, numero,bairro,cidade,estado,datanasc,tamanho,tel,email " +
               ") values (?,?,?,?,?,?,?,?,?,?,?)";       
       p=c.prepareStatement(sql);
       p.setString(1, editnome.getText());
       p.setString(2, editdono.getText());
       p.setString(3, editrua.getText());
       p.setInt(4, Integer.parseInt(editnum.getText()));
       p.setString(5, editbairro.getText());
       p.setString(6, editcidade.getText());
       p.setString(7, comboboxestado.getSelectedItem().toString());
       p.setString(8, editdtnasc.getText());
       p.setInt(9, tam);
       p.setString(10, edittel.getText());
       p.setString(11, editemail.getText());
       p.execute();
       JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
       Limpar(); 
        }
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.toString());
      }

// TODO add your handling code here:
}//GEN-LAST:event_btcadastrarActionPerformed

private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
     try{
        Statement st2 = c.createStatement();
        ResultSet rs2 = st2.executeQuery("select * from animal "+
                "where nome = '"+editnome.getText()+"'");
        if (rs2.next()){
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);
            btcadastrar.setEnabled(false);
            codigo = rs2.getInt("idanimal");
            editnome.setText(rs2.getString("nome"));
            editdono.setText(rs2.getString("nomedono"));
            editrua.setText(rs2.getString("rua"));
            editnum.setText(Integer.toString(rs2.getInt("numero")));
            editbairro.setText(rs2.getString("bairro"));
            editcidade.setText(rs2.getString("cidade"));
            editdtnasc.setText(rs2.getString("datanasc"));
            edittel.setText(rs2.getString("tel"));
            editemail.setText(rs2.getString("email"));
            comboboxestado.setSelectedItem(rs2.getString("estado"));
            if (rs2.getInt("tamanho") == 1){
                comboboxtam.setSelectedIndex(0);
            }else if (rs2.getInt("tamanho") == 2){
                comboboxtam.setSelectedIndex(1);
            }else if (rs2.getInt("tamanho") == 3){
                comboboxtam.setSelectedIndex(2);
            }      
       }else{
          JOptionPane.showMessageDialog(null, "Animal não cadastrado!");
          Limpar();  
        }
      }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.toString());
      }
}//GEN-LAST:event_btbuscarActionPerformed

private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
    int tam = 0;
    if (comboboxtam.getSelectedItem().toString().equals("Pequeno")){
       tam = 1; 
    }else if (comboboxtam.getSelectedItem().toString().equals("Médio")){
       tam = 2; 
    }else if (comboboxtam.getSelectedItem().toString().equals("Grande")){
       tam = 3;    
    }
    try{
        Statement st3 = c.createStatement();
        ResultSet rs3 = st3.executeQuery("select nome from animal "+
                "where idanimal = "+codigo);
        if (rs3.next()){
            String sql = "update animal set" +
               " nome = ?, nomedono = ?, rua = ?, numero = ?, bairro = ?, cidade = ?,"+
               " estado = ?, datanasc = ?, tamanho = ?, tel = ?, email = ?"+
               " where idanimal = ?";       
            p=c.prepareStatement(sql);
            p.setString(1, editnome.getText());
            p.setString(2, editdono.getText());
            p.setString(3, editrua.getText());
            p.setInt(4, Integer.parseInt(editnum.getText()));
            p.setString(5, editbairro.getText());
            p.setString(6, editcidade.getText());
            p.setString(7, comboboxestado.getSelectedItem().toString());
            p.setString(8, editdtnasc.getText());
            p.setInt(9, tam);
            p.setString(10, edittel.getText());
            p.setString(11, editemail.getText());
            p.setInt(12,codigo);
            p.execute();
            JOptionPane.showMessageDialog(null,"Dados Alterados!");
            Limpar();
          }else{
                 
      }
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.toString());
      }
}//GEN-LAST:event_btAlterarActionPerformed

private void btcancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelaActionPerformed
    Limpar();
    // TODO add your handling code here:
}//GEN-LAST:event_btcancelaActionPerformed

private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
try{
    Statement st4 = c.createStatement();
    ResultSet rs4 = st4.executeQuery("select * from animal "+
                "where nome = '"+editnome.getText()+"'");
    if (rs4.next()){
        int codigo = rs4.getInt("idanimal");
        int resp = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir esse registro?",
                 "Confirmar Exclusão",JOptionPane.YES_NO_OPTION);
        if (resp == 0){
            String sql = "delete from agenda " +
                      " where idanimal = ?";
            p=c.prepareStatement(sql);
            p.setInt(1,codigo);
            p.execute();
            sql = "delete from animal " +
                  " where nome = ?";
            p=c.prepareStatement(sql);
            p.setString(1, editnome.getText());
            p.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido");  
            editnome.requestFocus();
        }else{
            Limpar();
        }      
    }else{
        JOptionPane.showMessageDialog(null,"Registro não encontrado!");
    }
    Limpar();
    }catch(Exception e){
         JOptionPane.showMessageDialog(null,e.toString()); 
      }
}//GEN-LAST:event_btExcluirActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAnimais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btcadastrar;
    private javax.swing.JButton btcancela;
    private javax.swing.JButton btsair;
    private javax.swing.JComboBox comboboxestado;
    private javax.swing.JComboBox comboboxtam;
    private javax.swing.JTextField editbairro;
    private javax.swing.JTextField editcidade;
    private javax.swing.JTextField editdono;
    private javax.swing.JFormattedTextField editdtnasc;
    private javax.swing.JTextField editemail;
    private javax.swing.JTextField editnome;
    private javax.swing.JTextField editnum;
    private javax.swing.JTextField editrua;
    private javax.swing.JTextField edittel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
