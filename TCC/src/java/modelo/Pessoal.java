package modelo;

import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;

public class Pessoal extends Usuario{
    
    private int idPessoal;
    private String nome;
    private String cpf;
    private char sexo;
    private Date data_nasc;

    public int getIdPessoal() {
        return idPessoal;
    }

    public void setIdPessoal(int idPessoal) {
        this.idPessoal = idPessoal;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
    
}
