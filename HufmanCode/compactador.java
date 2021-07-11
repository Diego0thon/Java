import java.io.*;

public class compactador {
    public void comp(String pathIn) throws IOException {

        filaprioridade fila = new filaprioridade();
        arvoreHuff arvore = new arvoreHuff();
        File arquivo = new File(pathIn);

        int frequencia[] = new int[256];
        String binarios[] = new String[256];

        int count = 0;

        FileReader leitordearquivo = new FileReader(arquivo.getPath());
        BufferedReader entradabuffer = new BufferedReader(leitordearquivo);

        while (entradabuffer.ready()) { // incrementar frequencia
            String arquivotxt = entradabuffer.readLine();

            for (int i = 0; i < arquivotxt.length(); i++) {
                frequencia[arquivotxt.charAt(i)]++;
            }
            count++;
        }
        frequencia[(int) '\n'] = count - 1;


        for (int i = 0; i < frequencia.length; i++) { // criar fila
            if (frequencia[i] > 0) {
                fila.enqueue(((char) i), frequencia[i]);
            }
        }

        while (fila.contador > 1) { // gerador da arvore
            No aux = new No(null, 0);
            aux.esquerdo = fila.dequeue();
            aux.direito = fila.dequeue();
            aux.esquerdo.raiz = aux;
            aux.direito.raiz = aux;
            aux.frequencia = aux.esquerdo.frequencia + aux.direito.frequencia;
            fila.enqueue(aux);
        }

        arvore.raiz = fila.primeiro;

        binarios = arvore.geradorbi();

        File saida = new File("saida.txt");

        saida.createNewFile();

        FileWriter escritor = new FileWriter(saida);
        escritor.close();
        FileWriter escritor2 = new FileWriter(saida, true);
        PrintWriter print = new PrintWriter(escritor2);

        print.println(arvore.printbi());

        leitordearquivo.close();
        entradabuffer.close();

        leitordearquivo = new FileReader(arquivo.getPath());
        entradabuffer = new BufferedReader(leitordearquivo);

        while (entradabuffer.ready()) {
            String arquivotxt = entradabuffer.readLine();

            for (int i = 0; i < arquivotxt.length(); i++) {
                print.print(binarios[(arquivotxt.charAt(i))]);
            }

            if (binarios[('\n')] != null && count > 0) {
                print.print(binarios[('\n')]);
                count--;
            }
        }
        print.close();
        escritor2.close();

    }

}
