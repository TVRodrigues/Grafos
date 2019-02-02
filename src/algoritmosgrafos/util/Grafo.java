package algoritmosgrafos.util;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    
    private List<Integer> V;
    private List<Aresta> E;
    private int[][] matrizAdj;
    private ArrayList<ArrayList<Integer>> listaAdj;

    public Grafo(List<Integer> V, List<Aresta> E, int[][] matrizAdj, ArrayList<ArrayList<Integer>> listaAdj) {
        this.V = V;
        this.E = E;
        this.matrizAdj = matrizAdj;
        this.listaAdj = listaAdj;
    }

    public List<Integer> getV() {
        return V;
    }

    public void setV(List<Integer> V) {
        this.V = V;
    }

    public List<Aresta> getE() {
        return E;
    }

    public void setE(List<Aresta> E) {
        this.E = E;
    }

    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    public void setMatrizAdj(int[][] matrizAdj) {
        this.matrizAdj = matrizAdj;
    }

    public ArrayList<ArrayList<Integer>> getListaAdj() {
        return listaAdj;
    }

    public void setListaAdj(ArrayList<ArrayList<Integer>> listaAdj) {
        this.listaAdj = listaAdj;
    }

    public void imprimeListaAdjacencias() {
        //Imprime lista de adjacências
        for(int i = 0; i < V.size(); ++i) {
            System.out.print("[" + i + "] : ");
            for(int j = 0; j < listaAdj.get(i).size(); ++j){
                System.out.print(listaAdj.get(i).get(j) 
                        + " ");
            }
            System.out.println();
        }
    }
    
    
    
    
    
    
    
    

    
    
}
