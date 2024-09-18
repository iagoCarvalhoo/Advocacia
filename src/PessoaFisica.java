
// Classe Pessoa Física
class PessoaFisica extends Pessoa implements Cliente {

    public PessoaFisica(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String toString() {
        return "Pessoa Física: " + getNome() + " - CPF: " + getCpf();
    }
}

