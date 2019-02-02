package algoritmosgrafos;

import algoritmosgrafos.algoritmos.Busca;
import algoritmosgrafos.algoritmos.Cor;
import algoritmosgrafos.algoritmos.Info;
import algoritmosgrafos.util.Grafo;
import algoritmosgrafos.util.Leitor;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AlgoritmosGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Escolha o Grafo:");
            String NomeGrafo = in.nextLine();
            Leitor leitor = new Leitor();
            Grafo G = leitor.lerArquivo(NomeGrafo);
            Cor cor = new Cor(G);
            cor.GreedyCol();
            cor.recol();
            /**Imprime informações sobre o grafo
            Info info = new Info(G);
            System.out.println("Densidade: " + info.densidade());
            if(info.completo())
                System.out.println("Completo");
            if(info.regular())
                System.out.println("Regular");
            //Imprime complementar
            System.out.println("Complementar:");
            int[][] comp = info.complementar();
            for(int i = 0; i < G.getV().size(); ++i) {
                for(int j = 0; j < G.getV().size(); ++j) {
                    System.out.print("  " + comp[i][j]);
                }
                System.out.println();                    
            }
            //Buscas
            Busca busca = new Busca(G);
            System.out.println("Busca Largura:");
            busca.buscaLargura(0);
            System.out.println("Busca Profundidade:");
            busca = new Busca(G);
            busca.buscaProf(0);
            //Ordenacao topologica
            System.out.println("Ordenacao Topologica:");
            busca = new Busca(G);
            busca.ordTopologica();
            * 
            */
        } catch (IOException ex) {
            System.out.println("ERRO: Nao foi possivel ler o arquivo de entrada!");
        }
    }
    
}








