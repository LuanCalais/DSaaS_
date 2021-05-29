package modelo;

public class Funcionario extends Pessoal{
    private int idFunc; 
    private String turno;
    private String funcao;
    private Pessoal pessoal;
    private Usuario usuario;

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

        public Pessoal getPessoal() {
        return pessoal;
    }

    public void setPessoal(Pessoal pessoal) {
        this.pessoal = pessoal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
