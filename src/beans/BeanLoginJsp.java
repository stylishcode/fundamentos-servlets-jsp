package beans;

public class BeanLoginJsp {

	private String login;
	private String senha;
	
	
	public boolean isLoginValido(String login, String senha) {
		if (login.equalsIgnoreCase("admin") && senha.equals("admin")) {
			return true;
		}
		return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
