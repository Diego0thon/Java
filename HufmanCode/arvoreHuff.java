public class arvoreHuff {
    public No raiz;
    StringBuilder result;
    int count = 0;

    public arvoreHuff() {
        this.raiz = null;
    }

    public void preordem() {
        if (raiz != null) {
            preordem(raiz);
            System.out.println();
        }
    }

    public void preordem(No no) {
        if (no.equals(raiz)) {
            System.out.print(no.caractere);
        } else {
            System.out.print(" " + no.caractere);
        }

        if (no.esquerdo != null) {
            preordem(no.esquerdo);
        }
        if (no.direito != null) {
            preordem(no.direito);
        }
    }

    public String[] geradorbi() {
        String binarios[] = new String[256];

        if (raiz != null) {
            binarios = geradorbi(raiz, binarios);
        }
        return binarios;
    }

    public String[] geradorbi(No no, String[] binarios) {
        String elemento = null;

        if (no.caractere != null) {
            elemento = "";
            binarios[(char) no.caractere] = codigoHuff(no, elemento);
        }

        if (no.esquerdo != null) {
            binarios = geradorbi(no.esquerdo, binarios);
        }
        if (no.direito != null) {
            binarios = geradorbi(no.direito, binarios);
        }
        return binarios;
    }

    public String codigoHuff(No no, String elemento) {
        if (no.raiz != null && no.raiz != this.raiz) {
            elemento = codigoHuff(no.raiz, elemento);
        }
        if (no.equals(no.raiz.esquerdo)) {
            elemento += "0";
        }
        if (no.equals(no.raiz.direito)) {
            elemento += "1";
        }
        return elemento;
    }

    public String printbi() {
        String elemento = "";
        if (raiz != null) {
            elemento = printbi(raiz, elemento);
        }
        return elemento;
    }

    public String printbi(No no, String elemento) {
        if (no.caractere != null) {
            elemento += "1";
            String stringbinaria = Integer.toBinaryString((char) no.caractere);
            if (stringbinaria.length() < 8) {
                for (int i = 0; i < (8 - stringbinaria.length()); i++) {
                    elemento += "0";
                }
            }
            elemento += stringbinaria;
        } else {
            elemento += "0";
        }
        if (no.esquerdo != null) {
            elemento = printbi(no.esquerdo, elemento);
        }
        if (no.direito != null) {
            elemento = printbi(no.direito, elemento);
        }
        return elemento;
    }

    public char[] caracters(String txt) {
        char[] letras = new char[txt.length()];
        txt.getChars(0, txt.length(), letras, 0);
        return letras;
    }

    public char caracters(String txt, int count) {
        char[] letras = new char[txt.length()];
        txt.getChars(0, txt.length(), letras, 0);
        return letras[count];
    }

    public String descomp(String elemento) {
        No aux = raiz;

        StringBuilder result = new StringBuilder();

        for (char bi : caracters(elemento)) {
            if (bi == '0') {
                aux = aux.esquerdo;
            } else {
                aux = aux.direito;
            }

            if (aux.esquerdo == null && aux.direito == null) {
                result.append(aux.caractere);
                aux = raiz;
            }
        }
        return result.toString();
    }

    public void geradorarvore(String elemento) {
        raiz = new No(null, 0);
        geradorarvore(raiz, elemento);
    }

    public void geradorarvore(No no, String elemento) {
        if (count < caracters(elemento).length) {
            if (caracters(elemento, count) == '0') {
                count++;
                if (no.esquerdo == null) {
                    no.esquerdo = new No(null, 0);
                    geradorarvore(no.esquerdo, elemento);
                }
                if (no.direito == null) {
                    no.direito = new No(null, 0);
                    geradorarvore(no.direito, elemento);
                }
            } else if (caracters(elemento, count) == '1') {
                int aux = count + 8;
                result = new StringBuilder();
                for (int x = count + 1; x <= aux; x++) {
                    result.append(caracters(elemento, count + 1));
                    count++;
                }
                count++;
                no.caractere = (char) Integer.parseInt(result.toString(), 2);
            }
        }
    }
}
