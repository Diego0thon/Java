public class No {
    public Object caractere;
    public int frequencia;
    public No raiz;
    public No esquerdo;
    public No direito;
    public No proximo;
    public No anterior;

    public No(Object caractere, int frequencia) {
        this.caractere = caractere;
        this.frequencia = frequencia;
        this.raiz = null;
        this.esquerdo = null;
        this.direito = null;
        this.proximo = null;
        this.anterior = null;
    }
}
