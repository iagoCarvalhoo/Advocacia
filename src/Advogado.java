
// Classe Advogado
class Advogado {
    private String nome;
    private String cpf;
    private AreaAtuacao areaAtuacao;

    public Advogado(String nome, String cpf, AreaAtuacao areaAtuacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.areaAtuacao = areaAtuacao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public AreaAtuacao getAreaAtuacao() {
        return areaAtuacao;
    }
}

