package algoritmosgrafos.algoritmos;

import algoritmosgrafos.util.Grafo;

public class Info {
    
    private Grafo G;

    public Info(Grafo G) {
        this.G = G;
    }
    
    public boolean completo() {
        for(int i = 0; i < G.getV().size(); ++i) {
            if(G.getListaAdj().get(i).size() !=
                    G.getV().size() - 1)
                return false;
        }
        return true;
    }
    
    public double densidade() {
        return G.getE().size() / 
                (double) (G.getV().size() * (G.getV().size() - 1));
    }
    
    public boolean regular() {
        int grau = G.getListaAdj().get(0).size();
        for(int i = 1; i < G.getV().size(); ++i) {
            if(G.getListaAdj().get(i).size() != grau)
                return false;
        }
        return true;        
    }
    
    public int[][] complementar() {
        int[][] comp = //G.getMatrizAdj().clone();
                new int[G.getV().size()][G.getV().size()];
        for(int i = 0; i < G.getV().size(); ++i) {
            for(int j = 0; j < G.getV().size(); ++j) {
                if(i != j) {
                    if(G.getMatrizAdj()[i][j] == 0)
                        comp[i][j] = 1;
                    else
                        comp[i][j] = 0;
                }
            }
        }
        return comp;
    }
}