/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgrafos.algoritmos;

import algoritmosgrafos.util.Grafo;
import java.util.ArrayList;

/**
 *
 * @author George
 */
public class Busca {
    
    private Grafo G;
    private int[] visitado;
    private ArrayList<Integer> ORDEM;
    private ArrayList<Integer> cores;
    
    public Busca(Grafo G) {
        this.G = G;
        visitado = new int[G.getV().size()];
        ORDEM = new ArrayList<>();
        cores = new ArrayList<>();
    }
    
    public void buscaLargura(int s) {
        for(int i = 0; i < G.getV().size(); ++i) 
            visitado[i] = 0;
        visitado[s] = 1;
        System.out.println(s);
        ArrayList<Integer> F = new ArrayList<Integer>();
        F.add(s);
        while(! F.isEmpty()) {
            int u = F.remove(0);
            for(int i = 0; i < G.getListaAdj().get(u).size(); ++i) {
                int v = G.getListaAdj().get(u).get(i);
                if(visitado[v] == 0) {
                    visitado[v] = 1;
                    System.out.println(v);
                    F.add(v);
                }
            }
        }
    }
    
    public void buscaProf(int s) {
        visitado[s] = 1;
        System.out.println(s);
        for(int i = 0 ; i < G.getListaAdj().get(s).size(); ++i) {
            int v = G.getListaAdj().get(s).get(i);
            if(visitado[v] == 0)
                buscaProf(v);
        }
    }
    
    public void GreedyCol(){
        ArrayList<Integer> S = new ArrayList<>();
        ArrayList<Integer> Cores = new ArrayList<>();
        ArrayList<Integer> CoresPossiveis = new ArrayList<>();
        for(int i = 0; i<G.getV().size(); ++i){
            S.add(i);
            Cores.add(i);
        }
        for(int i = 0; i<G.getV().size(); ++i){
            CoresPossiveis=Cores;
            for(int j = 0; j<Cores.size(); ++j){
                for(int k = 0; k<G.getListaAdj().get(i).size(); ++k){
                    if(S.get(k) == j && j == CoresPossiveis.get(k)){
                        CoresPossiveis.remove(k);
                    }
                }
                S.set(i, CoresPossiveis.get(0));
            }
        }
        System.out.println(S.size());
    }
    
    
    
    public void profCon(int u, int marca) {
        visitado[u] = marca;
        System.out.println(u + ": " + marca);
        for(int i = 0; i < G.getListaAdj().get(u).size(); ++i) {
            int v = G.getListaAdj().get(u).get(i);
            if(visitado[v] == 0)
                profCon(v, marca);
        }
    }
    
    public void componentesConexas() {
        for(int i = 0; i < G.getV().size(); ++i) {
            visitado[G.getV().get(i)] = 0;
        }
        int marca = 0;
        for(int i = 0; i < G.getV().size(); ++i) {
            int v = G.getV().get(i);
            if(visitado[v] == 0) {
                ++marca;
                profCon(v, marca);
            }
        }
    }
    
    public void ordTopologica() {
        for(int i = 0; i < G.getV().size(); ++i) {
            visitado[i] = 0;
        }
        for(int i = 0; i < G.getV().size(); ++i) {
            if(visitado[i] == 0)
                profOrd(i);
        }        
    }
    
    public void profOrd(int u) {
        visitado[u] = 1;
        for(int i = 0; i < G.getListaAdj().get(u).size(); ++i) {
            int v = G.getListaAdj().get(u).get(i);
            if(visitado[v] == 0)
                profOrd(v);
        }
        ORDEM.add(0, u);
        System.out.println(ORDEM);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}







