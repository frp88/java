
import com.sun.faces.taglib.jsf_core.ConvertDateTimeTag;
import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

public class SevletBuscaFilme extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String dtPaux = request.getParameter("data");
            ConexaoFilme con = new ConexaoFilme();
            int msg = con.Conecta();
            if (msg != 0) {
                out.println(con.getMsg(msg));
            } else {
                String b = request.getParameter("botao");
                if (b.equals("Pesquisar")) {
                    try {
                        String dtP = con.formataData(dtPaux);
                        ResultSet rs = con.buscaFilmesCartaz(dtP);
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Pesquisa de Filmes em Cartaz</title>");
                        out.println("</head>");
                        out.println("<body bgcolor=\"6dc3e4\">");
                        out.println("<center><h1>Filmes em Cartaz - Pesquisa de Filmes em Cartaz</h1><center/>");
                        out.println("<a href=\"TelaPrincipal.html\">Inicio</a>");
                        out.println("<a href=\"ControleFilme.html\">Controle de Filmes</a>");
                        out.println("<a href=\"ConsultaFilme.html\">Consulta de Filmes em Cartaz</a><br>");
                        out.println("<form action=\"SevletBuscaFilme\" method=\"get\">");
                        out.println("<br> <label><b>Digite   uma   data   para   pesquisa:</b></label><br>");
                        out.println("<input type=\"text\" name=\"data\" value=\"" + dtPaux + "\" maxlength=\"10\" style=\"width:100px;\"> Ex: DD/MM/AAAA");
                        out.println("<br><br><input type=\"submit\" name =\"botao\" value=\"Pesquisar\" style=\"width:230px;\" /><br> <br>");
                        out.println("<br><b>Lista de Filmes em Cartaz</b><br>");
                        out.println("</form>");
                        out.println("</body>");
                        out.println("</html>");
                        String resu = "";
                        String aData = "";
                        String nDataE = "";
                        String nDataS = "";
                        String codFilme = "";
                        while (rs.next()) {
                            codFilme = rs.getString("idFilme");
                            aData = (rs.getString("dtEstreia")).substring(0, 10);
                            nDataE = con.dataPadraoBrasil(aData);
                            aData = (rs.getString("dtSaida")).substring(0, 10);
                            nDataS = con.dataPadraoBrasil(aData);
                            resu += "==> " + codFilme + " - " + rs.getString("nome") + " - " + nDataE + " - " + nDataS + " - " + rs.getString("sinopse") + "\n";
                        }
                        out.println("<textarea name=\"sinop\" style=\"width:500px; height:300px;\">" + resu + "</textarea><br> ");

                        if (resu.equals("")) {
                            out.println("<script>");
                            out.println("alert(\'Nenhum filme em cartaz nesta data!\')");
                            out.println("</script>");
                        }
                    } catch (Exception e) {
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