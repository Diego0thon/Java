public class filaprioridade {
    public No primeiro;
    public No ultimo;
    public int contador;

    public filaprioridade() {
        this.primeiro = null;
        this.ultimo = null;
        this.contador = 0;
    }

    public void enqueue(char caractere, int frequencia) {
        No novo = new No(caractere, frequencia);

        if (primeiro == null) { // Lista vazia
            primeiro = novo;
            ultimo = novo;
        } else if (novo.frequencia < primeiro.frequencia) { // Inicio da lista
            novo.proximo = primeiro;
            primeiro.anterior = novo;
            primeiro = novo;
        } else if (novo.frequencia >= ultimo.frequencia) { // Final da lista
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        } else {
            No aux = null;
            No atual = primeiro;

            while (atual != null && novo.frequencia >= atual.frequencia) {
                aux = atual;
                atual = atual.proximo;
            }

            aux.proximo = novo;
            novo.anterior = aux;
            novo.proximo = atual;
            atual.anterior = novo;
        }
        contador++;
    }

    public void enqueue(No no) {
        if (primeiro == null) { // Lista vazia
            primeiro = no;
            ultimo = no;
        } else if (no.frequencia < primeiro.frequencia) { // Inicio da lista
            no.proximo = primeiro;
            primeiro.anterior = no;
            primeiro = no;
        } else if (no.frequencia >= ultimo.frequencia) { // Final da lista
            ultimo.proximo = no;
            no.anterior = ultimo;
            ultimo = no;
        } else {
            No aux = null;
            No atual = primeiro;

            while (atual != null && no.frequencia >= atual.frequencia) {
                aux = atual;
                atual = atual.proximo;
            }

            aux.proximo = no;
            no.anterior = aux;
            no.proximo = atual;
            atual.anterior = no;
        }
        contador++;
    }

    public No dequeue() {
        No aux = null;
        if (primeiro != null) {
            aux = primeiro;
            if (contador == 1) {
                primeiro = null;
                ultimo = null;
            } else {
                primeiro = primeiro.proximo;
                primeiro.anterior.proximo = null;
                primeiro.anterior = null;
                aux.anterior = null;
                aux.proximo = null;
            }
            contador--;
        }
        return aux;
    }
}