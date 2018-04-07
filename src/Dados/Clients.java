
package Dados;

public class Clients
{
    //Fields
    private int id_cliente;
    private String nome;
    private String telefone;
    private String email;

    public Clients() {

    }
    public Clients(int id_cliente, String nome, String email, String telefone) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id_cliente=" + id_cliente +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
