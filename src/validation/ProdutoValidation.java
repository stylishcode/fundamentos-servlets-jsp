package validation;

import beans.Produto;

public class ProdutoValidation {
    private StringBuilder erros = new StringBuilder();
    
    public StringBuilder validarCampos(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty() || produto.getNome().isBlank()) {
            erros.append("Nome, ");
        }
        
        if (produto.getQuantidade() == null) {
            erros.append("Quantidade, ");
        }
        
        if (produto.getValor() == null) {
            erros.append("Valor R$, ");
        }
        
        /*Remove a virgula e espaço do último elemento*/ 
        if (erros.length() > 0) {
            erros.replace(erros.length() - 2, erros.length() + 1, "");
        }
               
        return erros.length() > 0 ? erros : null;
    }
}
