package validation;

import beans.UsuarioBean;

public class UsuarioValidation {
    private StringBuilder erros = new StringBuilder();
    
    
    public StringBuilder validarCampos(UsuarioBean user) {
        if (user.getNome() == null || user.getNome().isEmpty() || user.getNome().isBlank()) {
            erros.append("Nome, ");
        }
        
        if (user.getTelefone() == null || user.getTelefone().isEmpty() || user.getTelefone().isBlank()) {
            erros.append("Telefone, ");
        }
        
        if (user.getLogin() == null || user.getLogin().isEmpty() || user.getLogin().isBlank()) {
            erros.append("Login, ");
        }
        
        if (user.getSenha() == null || user.getSenha().isEmpty() || user.getSenha().isBlank()) {
            erros.append("Senha, ");
        }
        
        if (user.getIbge() == null || user.getIbge().isEmpty() || user.getIbge().isBlank()) {
            erros.append("IBGE, ");
        }
        
        if (user.getCep() == null || user.getCep().isEmpty() || user.getCep().isBlank()) {
            erros.append("CEP, ");
        }
        
        if (user.getRua() == null || user.getRua().isEmpty() || user.getRua().isBlank()) {
            erros.append("Rua, ");
        }
        
        if (user.getBairro() == null || user.getBairro().isEmpty() || user.getBairro().isBlank()) {
            erros.append("Bairro, ");
        }
        
        if (user.getCidade() == null || user.getCidade().isEmpty() || user.getCidade().isBlank()) {
            erros.append("Cidade, ");
        }
        
        if (user.getEstado() == null || user.getEstado().isEmpty() || user.getEstado().isBlank()) {
            erros.append("Estado, ");
        }
        
        /*Remove a virgula e espaço do último elemento*/ 
        if (erros.length() > 0) {
            erros.replace(erros.length() - 2, erros.length() + 1, "");
        }
               
        return erros.length() > 0 ? erros : null;
    }
}
