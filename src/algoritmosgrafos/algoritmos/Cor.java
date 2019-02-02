/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgrafos.algoritmos;

import algoritmosgrafos.util.Grafo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Thiago-PC
 */
public class Cor {
    private Grafo G;
    private int[] S;
    private ArrayList<Integer> Cores;

    public Cor(Grafo G) {
        this.G = G;
        this.S = new int[G.getV().size()];
        this.Cores = new ArrayList<>();
    }
    
    public void GreedyCol(){
        for(int i = 0; i < G.getV().size(); ++i){
            S[i]=i+1;          
        }
        for(int i = 1; i <= G.getV().size(); ++i){
            Cores.add(i);            
        }
        for(int i = 0; i < G.getV().size(); ++i){            
            ArrayList<Integer> CoresPossiveis = new ArrayList<>();
            CoresPossiveis.addAll(Cores);
            for(int j = 0; j < Cores.size(); ++j){
                for(int k = 0; k < G.getListaAdj().get(i).size(); ++k){
                    if(S[k] == j && CoresPossiveis.contains(j)){
                        CoresPossiveis.remove((Integer) j);
                    }
                }
            }
            S[i] = CoresPossiveis.get(0);
        }
        System.out.println(Arrays.toString(S));
        
    }
    
    public void recol(){
        int u, c;        
        int[] T = new int[G.getV().size()];
        int[] U = new int[G.getV().size()];
        Cores = new ArrayList<>();
        for(int i = 0; i < S.length; ++i){
            if(!Cores.contains(S[i]))
                Cores.add(S[i]);
        }
        System.out.println("Cores GreedyCol: " + Cores.size());        
        System.out.println("Processando...");
        int iter = 0;
        while(iter < 10000000){
            ++iter;
            Random random = new Random();
            u = random.nextInt(G.getV().size());
            c = random.nextInt(Cores.size()-1);
            for(int i = 0; i < G.getV().size(); i++){
                T[i] = S[i];
            }
            T[u] = c;
            int a=1;
            for(int i = 0; i < G.getListaAdj().get(u).size(); ++i){
                if(T[u] == T[G.getListaAdj().get(u).get(i)]){
                    a=0;                    
                }
            }
            if(a==1){
                ArrayList<Integer> Cores2 = new ArrayList<>();
                for(int i = 0; i < S.length; ++i){
                if(!Cores2.contains(S[i]))
                    Cores2.add(S[i]);
                }
                if(Cores2.size() <= Cores.size()){
                    for(int i = 0; i < G.getV().size(); i++){
                           U[i] = T[i];    
                     }
                     Cores = (ArrayList<Integer>) Cores2.clone();
                }
            }
        }
        System.out.println("Cores Recol: "+ Cores.size());
        System.out.println("Coloração: " + Arrays.toString(U));
    }

    
    
    
}
