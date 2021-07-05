package modelo;

public interface Viatura {
    // Método que será executado quando o 
    // "sujeito" (classe "CarroRoubado") for notiticar os
    // "observadores" (classes que implementar a "Viatura")
    public void atualizaAcao(String acao);
}
