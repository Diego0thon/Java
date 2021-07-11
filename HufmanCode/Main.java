import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc2 = new Scanner(System.in);
        compactador compactador = new compactador();
        descompatador descompatador = new descompatador();

        JFileChooser selecionador = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt"
                , "text");
        selecionador.setFileFilter(filter);
        int respostaselecionador = selecionador.showOpenDialog(null);
        String caminho = " ";

        if (respostaselecionador == JFileChooser.APPROVE_OPTION) {
            File arquivodetexto = selecionador.getSelectedFile();
            caminho = arquivodetexto.getAbsolutePath();

            String endereço = caminho;
            System.out.print("Deseja compactar ou descompactar? : ");
            String comando = sc2.nextLine();

            if (comando.equals("compactar")) {
                compactador.comp(endereço);
                System.out.println("Arquivo Compactado com sucesso");
            } else if (comando.equals("descompactar")) {
                descompatador.descomp(endereço);
                System.out.println("Arquivo Descompactado com sucesso");
            } else {
                System.err.println("Ação invalida");
            }

        } else {
            System.err.println("Nenhum arquivo selecionado");
        }
    }
}
