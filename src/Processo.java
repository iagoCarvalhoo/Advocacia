
// Classe Processo
class Processo {
    private String numeroProcesso;
    private String nomeTribunal;
    private Advogado advogado;
    private Cliente cliente;
    private double honorarios;

    public Processo(String numeroProcesso, String nomeTribunal, Advogado advogado, Cliente cliente, double honorarios) {
        this.numeroProcesso = numeroProcesso;
        this.nomeTribunal = nomeTribunal;
        this.advogado = advogado;
        this.cliente = cliente;
        this.honorarios = honorarios;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public String getNomeTribunal() {
        return nomeTribunal;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getHonorarios() {
        return honorarios;
    }
}

