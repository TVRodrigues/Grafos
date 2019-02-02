package algoritmosgrafos.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {
    
    private Grafo G;
    private File file;
    
    public Leitor() {
        
    }   
    
    public Grafo lerArquivo(String nome) 
            throws FileNotFoundException, IOException {
        //Abre arquivo e cria buffer de leitura
        file = new File(nome);        
        FileReader leitor = new FileReader(file);
        BufferedReader bufferLeitura = new BufferedReader(leitor);
        
        //Lê cabeçalho do arquivo
        String linha = bufferLeitura.readLine();
        String[] linhaQuebra = linha.split(" ");
        int numVertices = Integer.parseInt(linhaQuebra[0]);
        int numArestas = Integer.parseInt(linhaQuebra[1]);
        
        //Criar as estruturas de dados do Grafo
        ArrayList<Integer> V = new ArrayList<Integer>();
        ArrayList<Aresta> E = new ArrayList<Aresta>();
        int[][] matrizAdj = new int[numVertices][numVertices];
        ArrayList<ArrayList<Integer>> listaAdj = 
                new ArrayList<ArrayList<Integer>>();
        
        //Inicializa matriz de adjacências (com zeros)
        for(int i = 0; i < numVertices; ++i) {
            for(int j = 0; j < numVertices; ++j) {
                matrizAdj[i][j] = 0;
            }
        }
        
        //Inicializa lista de adjacências (cria sub-listas vazias)
        for(int i = 0; i < numVertices; ++i) {
            ArrayList<Integer> listaAdjI = new ArrayList<Integer>();
            listaAdj.add(listaAdjI);
        }
        
        //Preenche as estruturas de dados
        for(int i = 0; i < numVertices; ++i) {
            V.add(i);
        }
        for(int i = 0; i < numArestas; ++i) {
            String linhaAresta = bufferLeitura.readLine();
            String[] linhaArestaQuebra = linhaAresta.split(" ");
            int u = Integer.parseInt(linhaArestaQuebra[0]);
            int v = Integer.parseInt(linhaArestaQuebra[1]);
            int w = Integer.parseInt(linhaArestaQuebra[2]);
            Aresta e = new Aresta(u, v, w);
            //Adiciona aresta à lista de arestas
            E.add(e);
            //Muda (u, v) para 1 na matriz de adjacências
            matrizAdj[u][v] = 1;
            //Adiciona v na lista de adjacências do vértice u
            listaAdj.get(u).add(v);
        }
        
        G = new Grafo(V, E, matrizAdj, listaAdj);
        
        //Fecha arquivo
        bufferLeitura.close();
        leitor.close();
        return G;
    }
    
}