/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tradutor;

/**
 *
 * @author Bruno e Fernando
 */
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Tradutor {
    public static void main(String[] args) {
        int f = 20;
        int cont = 0;
        String por[] = new String[f];
        String ing[] = new String[f];
        int op = 0;
        String vopc = "";
        boolean fim = false;
         while (op!=4){
              op = 0;
              vopc = JOptionPane.showInputDialog(null,
              "Escolha uma opção:\n"+
              "1 - Cadastrar Palavras\n2 - Traduzir de Português para Inglês\n"+
              "3 - Traduzir de Inglês para Português\n4 - Sair");
              if ((vopc==null)||(vopc.equals(""))){
                  JOptionPane.showMessageDialog(null,"Digite uma Opção !!!");
              }
              else if ((vopc.equals("1"))||(vopc.equals("2"))||(vopc.equals("3"))||(vopc.equals("4"))){
                  op = Integer.parseInt(vopc);
              }
              else{
                  JOptionPane.showMessageDialog(null, "Opção Inválida !!!");
              }
              if (op == 1){
                  fim= false;
                  if (cont >= f){
                      JOptionPane.showMessageDialog(null,"Não é possivel cadastrar mais palavras !!!");                   
                      fim= true;
                 }    
                 if (fim == false){
                     while ((cont < f) && (fim == false)){
                         por[cont] = JOptionPane.showInputDialog(null,
                                "Digite uma Palavra em Português");
                         if (por[cont] == null){
                            break;
                         }
                         ing[cont] = JOptionPane.showInputDialog(null,
                                "Digite sua Tradução em Inglês");
                         if (ing[cont] == null){
                            break;
                         }
                         int num = JOptionPane.showConfirmDialog(null,"Deseja cadastrar mais palavras?",
                                 "Cadastrar mais?",JOptionPane.YES_NO_OPTION);
                         if (num == 1){
                            fim = true;         
                         }
                         cont++;
                     }
                 }
              }
              if (op == 2){
                String frase = JOptionPane.showInputDialog(null,
                    "Digite uma Frase ou Palavra em Português");
                if (frase!=null){
                   String aux = "";
                   String trad = "";
                   String p ="";
                   boolean achei = false;
                   boolean b = false;
                   int i = 0;
                   int j = 0;
                   int tam = frase.length();
                   for (i = 0;  i <= tam; i++){
                      if ((i==tam)||(frase.charAt(i) == ' ')){
                         b = true;
                      }
                      else if ((frase.charAt(i)!='.')&&(frase.charAt(i)!=',')
                              &&(frase.charAt(i)!=';')&&(frase.charAt(i)!='!')
                              &&(frase.charAt(i)!='?')){
                         aux += frase.charAt(i);
                      }
                      else{
                         p+=frase.charAt(i);
                      }
                      if (b){
                         achei = false;
                         j = 0;
                         while ((j < cont)&&(!achei)){
                            if (aux.equalsIgnoreCase(por[j])){
                               trad += ing[j];
                               achei = true;
                            }
                            else{
                               j++;
                            }
                         }
                         if (achei == false){
                            trad+= aux;
                         }
                         if (p == ""){
                            trad+= " ";
                         }
                         else{
                            trad+= p+" ";
                         }
                         p = "";
                         aux = "";
                         b = false;
                      }
                   }
                   JTextArea saida = new JTextArea();
                   saida.append("Frase ou Palavra a ser Traduzida:\n"+frase+"\n\nTradução:\n"+trad);
                   JOptionPane.showMessageDialog(null,saida,"Tradução em Inglês",JOptionPane.CLOSED_OPTION);
                }
             }
             if (op == 3){
                String frase = JOptionPane.showInputDialog(null,
                    "Digite uma Frase ou Palavra em Inglês");
                if (frase!=null){
                   String aux = "";
                   String trad = "";
                   String p ="";
                   boolean achei = false;
                   boolean b = false;
                   int i = 0;
                   int j = 0;
                   int tam = frase.length();
                   for (i = 0;  i <= tam; i++){
                      if ((i==tam)||(frase.charAt(i) == ' ')){
                         b = true;
                      }
                      else if ((frase.charAt(i)!='.')&&(frase.charAt(i)!=',')
                              &&(frase.charAt(i)!=';')&&(frase.charAt(i)!='!')
                              &&(frase.charAt(i)!='?')){
                         aux += frase.charAt(i);
                      }
                      else{
                         p+=frase.charAt(i);
                      }
                      if (b){
                         achei = false;
                         j = 0;
                         while ((j < cont)&&(!achei)){
                            if (aux.equalsIgnoreCase(ing[j])){
                               trad += por[j];
                               achei = true;
                            }
                            else{
                               j++;
                            }
                         }
                         if (achei == false){
                            trad+= aux;
                         }
                         if (p == ""){
                            trad+= " ";
                         }
                         else{
                            trad+= p+" ";
                         }
                         p = "";
                         aux = "";
                         b = false;
                      }
                   }
                   JTextArea saida = new JTextArea();
                   saida.append("Frase ou Palavra a ser Traduzida:\n"+frase+"\n\nTradução:\n"+trad);
                   JOptionPane.showMessageDialog(null,saida,"Tradução em Português",JOptionPane.CLOSED_OPTION);
               }
             }
         }
        if (op == 4){
            JOptionPane.showMessageDialog(null,"FIM DO PROGRAMA !!!");
        } 
        System.exit (0);
    }
}
 
        
        