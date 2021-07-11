import java.io.*;

public class descompatador {
    public void descomp(String path) throws IOException {
        arvoreHuff arvore = new arvoreHuff();
        File arquivo = new File(path);
        FileReader leitorarquivo = new FileReader(arquivo);
        BufferedReader buffer = new BufferedReader(leitorarquivo);

        arvore.geradorarvore(buffer.readLine());

        File saida = new File("saida.txt");

        saida.createNewFile();

        FileWriter escritor = new FileWriter(saida);
        escritor.close();
        FileWriter escritor2 = new FileWriter(saida, true);
        PrintWriter print = new PrintWriter(escritor2);

        print.println(arvore.descomp(buffer.readLine()));

        print.close();
        escritor2.close();
    }

}
