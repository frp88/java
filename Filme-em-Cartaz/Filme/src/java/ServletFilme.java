
import com.sun.faces.taglib.jsf_core.ConvertDateTimeTag;
import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

public class ServletFilme extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String cod = request.getParameter("codigo");
            String n = request.getParameter("nome");
            String dtEaux = request.getParameter("dataE");
            String dtSaux = request.getParameter("dataS");
            String dtPaux = request.getParameter("dataP");
            String s = request.getParameter("sinopse");
            String dtE = "";
            String dtS = "";
            String dtP = "";
            String aData = "";
            String nDataE = "";
            String nDataS = "";
            ConexaoFilme con = new ConexaoFilme();
            int msg = con.Conecta();
            if (msg != 0) {
                out.println(con.getMsg(msg));
            } else {
                String b = request.getParameter("botao");
                if (b.equals("Cadastrar")) {
                    dtE = con.formataData(dtEaux);
                    dtS = con.formataData(dtSaux);
                    boolean ok = con.insereFilme(n, dtE, dtS, s);//se der certo a conexão insere o aluno no banco de dados

                    if (ok == true) {
                        out.println("<script>");
                        out.println("alert(\'Cadastro Realizado com Sucesso!\')");
                        out.println("</script>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Pesquisa de Filmes em Cartaz</title>");
                        out.println("</head>");
                        out.println("<body bgcolor=\"6dc3e4\">");
                        out.println("<center><h1>Filmes em Cartaz - Inicio</h1><center/>");
                        out.println("<form>");
                        out.println("<a href=\"TelaPrincipal.html\">Inicio</a>");
                        out.println("<a href=\"ControleFilme.html\">Controle de Filmes</a>");
                        out.println("<a href=\"ConsultaFilme.html\">Consulta de Filmes em Cartaz</a><br>");
                        out.println("</form>");
                        out.println("<img src=\"shrek.jpg\" width=\"685\" height=\"514\" alt=\"shrek\"/>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else if (b.equals("Buscar")) {
                    try {
                        String cod2 = cod;
                        ResultSet r = con.buscaFilme(Integer.parseInt(cod2));
                        if (r.next()) {
                            aData = (r.getString("dtEstreia")).substring(0, 10);
                            nDataE = con.dataPadraoBrasil(aData);
                            aData = (r.getString("dtSaida")).substring(0, 10);
                            nDataS = con.dataPadraoBrasil(aData);
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Pesquisa de Filmes em Cartaz</title>");
                            out.println("<script type=\"text/javascript\" language=\"text/jascript\">");
                            out.println("function confirmaExclusao() {");
                            out.println("if(confirm(\"Deseja realmente excluir?\")) {");
                            out.println("document.getElementById('bt_excluir').click();");
                            out.println("}");
                            out.println("}");
                            out.println("</script>");
                            out.println("</head>");
                            out.println("<body bgcolor=\"6dc3e4\">");
                            out.println("<center><h1>Filmes em Cartaz - Controle de Filmes</h1><center/>");
                            out.println("<a href=\"TelaPrincipal.html\">Inicio</a>");
                            out.println("<a href=\"ControleFilme.html\">Controle de Filmes</a>");
                            out.println("<a href=\"ConsultaFilme.html\">Consulta de Filmes em Cartaz</a><br><br>");

                            out.println("<form action=\"ServletFilme\" method=\"get\">");

                            out.println("Digite o Código do Filme (apenas para consulta do filme)<br>");
                            out.println("<input type=\"text\" name=\"codigo\" value=\"" + cod2 + "\"/>");
                            out.println("<input type=\"submit\" name=\"botao\" value=\"Buscar\" /> <br><br><br>");
                            out.println("Nome <br> <input type=\"text\" name=\"nome\" value=\"" + r.getString("nome") + "\"style=\"width:210px;\"/> <br> <br>");
                            out.println("Data Estreia <br> <input type=\"text\" name=\"dataE\" value=\"" + nDataE + "\"style=\"width:210px;\"/> <br> <br>");
                            out.println("Data Saida <br> <input type=\"text\" name=\"dataS\" value=\"" + nDataS + "\"style=\"width:210px;\"/> <br> <br>");
                            out.println("Sinopse<br> <textarea name=\"sinopse\"style=\"width:210px;\">" + r.getString("sinopse") + "</textarea> <br><br> ");
                            out.println("<input type = \"submit\" name = \"botao\" value = \"Cadastrar\"  style=\"margin-left:-80px;\"/>");
                            out.println("<input type = \"submit\" name = \"botao\" value = \"Atualizar\" />");
                            out.println("<input type = \"submit\" name = \"botao\" value = \"Limpar\" />");

                            out.println("<input type=\"submit\" name =\"botao\" value=\"Excluir\" id=\"bt_excluir\" style=\"display:none;\" />");
                            out.println("</form>");
                            out.println("<input type=\"submit\" name =\"botao\" value=\"Excluir\" onclick=\"confirmaExclusao()\" style=\"position:absolute; margin-top:-40px; margin-left:80px;\" />");

                            out.println("</form>");
                            out.println("</body>");
                            out.println("</html>");
                        } else {
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Pesquisa de Filmes em Cartaz</title>");
                            out.println("</head>");
                            out.println("<body bgcolor=\"6dc3e4\">");
                            out.println("<center><h1>Filmes em Cartaz - Controle de Filmes</h1><center/>");
                            out.println("<a href=\"TelaPrincipal.html\">Inicio</a>");
                            out.println("<a href=\"ControleFilme.html\">Controle de Filmes</a>");
                            out.println("<a href=\"ConsultaFilme.html\">Consulta de Filmes em Cartaz</a><br><br>");

                            out.println("<form action=\"ServletFilme\" method=\"get\">");

                            out.println("Digite o Código do Filme (apenas para consulta do filme)<br>");
                            out.println("<input type=\"text\" name=\"codigo\"/>");
                            out.println("<input type=\"submit\" name=\"botao\" value=\"Buscar\" /> <br><br><br>");
                            out.println("Nome <br> <input type=\"text\" name=\"nome\"style=\"width:210px;\"/> <br> <br>");
                            out.println("Data Estreia <br> <input type=\"text\" name=\"dataE\"style=\"width:210px;\"/> <br> <br>");
                            out.println("Data Saida <br> <input type=\"text\" name=\"dataS\"style=\"width:210px;\"/><br> <br>");
                            out.println("Sinopse<br> <textarea name=\"sinopse\"style=\"width:210px;\"></textarea> <br><br> ");
                            out.println("<input type = \"submit\" name = \"botao\" value = \"Cadastrar\" style=\"margin-left:-12px;\"/>");
                            out.println("<input type = \"submit\" name = \"botao\" value = \"Atualizar\" />");
                            out.println("<input type = \"submit\" name = \"botao\" value = \"Limpar\" />");
                            out.println("<input type = \"submit\" name = \"botao\" value = \"Excluir\" />");

                            out.println("</form>");
                            out.println("</body>");
                            out.println("</html>");

                            out.println("<script>");
                            out.println("alert(\'Filme não cadastrado!\')");
                            out.println("</script>");
                        }
                    } catch (Exception e) {
                    }
                } else if (b.equals("Atualizar")) {
                    int nCod = Integer.parseInt(cod);
                    dtE = con.formataData(dtEaux);
                    dtS = con.formataData(dtSaux);
                    boolean ok = con.atualizaFilme(n, dtE, dtS, s, nCod);
                    if (ok == true) {
                        out.println("<script>");
                        out.println("alert(\'Dados Alterados com sucesso!\')");
                        out.println("</script>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Pesquisa de Filmes em Cartaz</title>");
                        out.println("</head>");
                        out.println("<body bgcolor=\"6dc3e4\">");
                        out.println("<center><h1>Filmes em Cartaz - Inicio</h1><center/>");
                        out.println("<form>");
                        out.println("<a href=\"TelaPrincipal.html\">Inicio</a>");
                        out.println("<a href=\"ControleFilme.html\">Controle de Filmes</a>");
                        out.println("<a href=\"ConsultaFilme.html\">Consulta de Filmes em Cartaz</a><br>");
                        out.println("</form>");
                        out.println("<img src=\"shrek.jpg\" width=\"685\" height=\"514\" alt=\"shrek\"/>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else if (b.equals("Limpar")) {

                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Pesquisa de Filmes em Cartaz</title>");
                    out.println("</head>");
                    out.println("<body bgcolor=\"6dc3e4\">");
                    out.println("<center><h1>Filmes em Cartaz - Controle de Filmes</h1><center/>");
                    out.println("<a href=\"TelaPrincipal.html\">Inicio</a>");
                    out.println("<a href=\"ControleFilme.html\">Controle de Filmes</a>");
                    out.println("<a href=\"ConsultaFilme.html\">Consulta de Filmes em Cartaz</a><br><br>");

                    out.println("<form action=\"ServletFilme\" method=\"get\">");

                    out.println("Digite o Código do Filme (apenas para consulta do filme)<br>");
                    out.println("<input type=\"text\" name=\"codigo\"/>");
                    out.println("<input type=\"submit\" name=\"botao\" value=\"Buscar\" /> <br><br><br>");
                    out.println("Nome <br> <input type=\"text\" name=\"nome\"style=\"width:210px;\"/> <br> <br>");
                    out.println("Data Estreia <br> <input type=\"text\" name=\"dataE\"style=\"width:210px;\"/> <br> <br>");
                    out.println("Data Saida <br> <input type=\"text\" name=\"dataS\"style=\"width:210px;\"/><br> <br>");
                    out.println("Sinopse<br> <textarea name=\"sinopse\"style=\"width:210px;\"></textarea> <br><br> ");
                    out.println("<input type = \"submit\" name = \"botao\" value = \"Cadastrar\" style=\"margin-left:-12px;\"/>");
                    out.println("<input type = \"submit\" name = \"botao\" value = \"Atualizar\" />");
                    out.println("<input type = \"submit\" name = \"botao\" value = \"Limpar\" />");
                    out.println("<input type = \"submit\" name = \"botao\" value = \"Excluir\" />");

                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                } else if (b.equals("Excluir")) {
                    int nCod = Integer.parseInt(cod);
                    boolean ok = con.excluiFilme(nCod);
                    if (ok == true) {
                        out.println("<script>");
                        out.println("alert(\'Filme excluido com sucesso!\')");
                        out.println("</script>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Pesquisa de Filmes em Cartaz</title>");
                        out.println("</head>");
                        out.println("<body bgcolor=\"6dc3e4\">");
                        out.println("<center><h1>Filmes em Cartaz - Inicio</h1><center/>");
                        out.println("<form>");
                        out.println("<a href=\"TelaPrincipal.html\">Inicio</a>");
                        out.println("<a href=\"ControleFilme.html\">Controle de Filmes</a>");
                        out.println("<a href=\"ConsultaFilme.html\">Consulta de Filmes em Cartaz</a><br>");
                        out.println("</form>");
                        out.println("<img src=\"shrek.jpg\" width=\"685\" height=\"514\" alt=\"shrek\"/>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }

            con.Desconecta();
        } finally {
            out.close();
        }
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
// </editor-fold>
}        