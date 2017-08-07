package dto;

public class UsuarioDTO {
    private String login;
    private String senha;
    private String email;

    public UsuarioDTO(){
        
    }
    public UsuarioDTO(String login, String senha, String email) {
        this.login = login;
        this.senha = senha;
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

    public UsuarioDTO(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    
}
