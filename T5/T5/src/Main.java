//java Main ..\dados\brasil.txt
//java Main ../dados/teste-ciclo5.txt

public class Main {
    private static final String[] STATES = {
        "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA",
        "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN",
        "RO", "RR", "RS", "SC", "SE", "SP", "TO"
    };

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java Main <caminho_do_arquivo>");
            return;
        }

        String filename = args[0];
        In in = new In(filename);
        if (!in.exists()) {
            System.out.println("Erro: Arquivo não encontrado: " + filename);
            return;
        }

        // 1. Construir o grafo
        Graph G = new Graph(in);
        in.close();

        // 2. Exibir a lista de adjacência
        System.out.println("--- Lista de Adjacência do Grafo (Brasil) ---");
        for (int v = 0; v < G.V(); v++) {
            System.out.print(STATES[v] + " (" + v + "): ");
            for (int w : G.adj(v)) {
                System.out.print(STATES[w] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // 3. Executar o algoritmo DSatur
        GraphColoringDSatur dsatur = new GraphColoringDSatur(G);

        // 4. Informar a ordem em que os estados foram coloridos
        System.out.println("--- Ordem de Coloração (DSatur) ---");
        for (int i = 0; i < dsatur.coloringOrder().size(); i++) {
            int v = dsatur.coloringOrder().get(i);
            System.out.print(STATES[v] + (i == dsatur.coloringOrder().size() - 1 ? "" : " -> "));
            if ((i + 1) % 9 == 0) System.out.println();
        }
        System.out.println("\n");

        // 5. Informar a cor atribuída a cada estado
        System.out.println("--- Cores Atribuídas ---");
        for (int v = 0; v < G.V(); v++) {
            System.out.printf("%-2s: Cor %d\n", STATES[v], dsatur.color(v));
        }
        System.out.println();

        // 6. Informar o total de cores utilizadas
        System.out.println("Total de cores utilizadas: " + dsatur.numColors());

        // 7. Verificar e informar se a coloração produzida é válida
        boolean isValid = dsatur.validate();
        System.out.println("A coloração é válida? " + (isValid ? "SIM" : "NÃO"));
    }
}
