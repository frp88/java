package ModelBO;

public class UsuarioBO {

    private String idUsuario;
    private String nome;
    private String senha;
    private StatusDeUsuario status;
    private TipoUsuario tipoUsuario;

    public UsuarioBO() {
    }

    public UsuarioBO(String idUsuario, String senha, String nome) {
        this.setIdUsuario(idUsuario);
        this.setSenha(senha);
        this.setNome(nome);
    }

    public UsuarioBO(String idUsuario, String senha, String nome, StatusDeUsuario status, TipoUsuario tipo) {
        this.setIdUsuario(idUsuario);
        this.setSenha(senha);
        this.setNome(nome);
        this.setStatus(status);
        this.setTipoUsuario(tipo);
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        if (idUsuario.length() >= 60) {
            this.idUsuario = idUsuario.substring(1, 60);
        } else {
            this.idUsuario = idUsuario;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome.length() >= 60) {
            this.nome = nome.substring(1, 60);
        } else {
            this.nome = nome;
        }
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        if (senha.length() >= 20) {
            this.senha = senha.substring(1, 20);
        } else {
            this.senha = senha;
        }
    }

    public boolean verificaIdUsuarioSenha(String idUsuario, String senha) {
        if ((idUsuario == this.idUsuario) && (senha == this.senha)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean verificaSenha(String senha) {
        if (senha == this.senha) {
            return true;
        } else {
            return false;
        }
    }

    public void trocaSenha(String senhaNova, String senhaVelha) {
        if (this.verificaSenha(senhaVelha)) {
            this.setSenha(senhaNova);
        }
    }

    public void ativa() {
        this.status = StatusDeUsuario.ativo;
    }

    public void desativa() {
        this.status = StatusDeUsuario.inativo;
    }

    public StatusDeUsuario getStatus() {
        return this.status;
    }
    
      public void setStatus(StatusDeUsuario statusUser) {
        this.status = statusUser;
    }


    public StatusDeUsuario StatusUser(int codStatus) {
        try {
            StatusDeUsuario status = null;
            switch (codStatus) {
                case 0:
                    status = StatusDeUsuario.ativo;
                    break;
                case 1:
                    status = StatusDeUsuario.inativo;
                    break;
            }
            return status;
        } catch (Exception e) {
            return null;
        }
    }

    public int codStatusUser(StatusDeUsuario statusUser) {
        try {
            int status = -1;
            switch (statusUser) {
                case ativo:
                    status = 0;
                    break;

                case inativo:
                    status = 1;
                    break;
            }

            return status;
        } catch (Exception e) {
            return -1;
        }
    }

    public void setTipoUsuario(TipoUsuario tipoUser) {
        this.tipoUsuario = tipoUser;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public TipoUsuario TipoUser(int codTipoUser) {
        try {
            TipoUsuario tipo = null;
            switch (codTipoUser) {
                case 0:
                    tipo = tipoUsuario.Master;
                    break;
                case 1:
                    tipo = tipoUsuario.Gerente;
                    break;
                case 2:
                    tipo = tipoUsuario.Almoxarife;
                    break;
                case 3:
                    tipo = tipoUsuario.RH;
                    break;
                case 4:
                    tipo = tipoUsuario.Professor;
                    break;
                default:
                    break;
            }

            return tipo;
        } catch (Exception e) {
            return null;
        }

    }

    public int codTipoUser(TipoUsuario tipoUser) {
        try {
            int tipo = -1;
            switch (tipoUser) {
                case Master:
                    tipo = 0;
                    break;

                case Gerente:
                    tipo = 1;
                    break;

                case Almoxarife:
                    tipo = 2;
                    break;

                case RH:
                    tipo = 3;
                    break;

                case Professor:
                    tipo = 4;
                    break;

                default:

                    break;
            }

            return tipo;
        } catch (Exception e) {
            return -1;
        }
    }
}
