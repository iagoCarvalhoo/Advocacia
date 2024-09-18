
// Classe Pessoa Jurídica
class PessoaJuridica extends Pessoa implements Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String cnpj) {
        super(nome, cnpj);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Jurídica: " + getNome() + " - CNPJ: " + cnpj;
    }
}


