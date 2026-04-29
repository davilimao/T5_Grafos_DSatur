import java.util.*;

public class GraphColoringDSatur {
    private int[] colors; 
    private int numColors;
    private List<Integer> coloringOrder;
    private final Graph G;

    public GraphColoringDSatur(Graph G) {
        this.G = G;
        this.colors = new int[G.V()];
        Arrays.fill(colors, -1);
        this.numColors = 0;
        this.coloringOrder = new ArrayList<>();
        solve();
    }

    private void solve() {
        int V = G.V();
        boolean[] colored = new boolean[V];
        
        int startVertex = -1;
        int maxDegree = -1;
        for (int v = 0; v < V; v++) {
            if (G.degree(v) > maxDegree) {
                maxDegree = G.degree(v);
                startVertex = v;
            }
        }
        
        colorVertex(startVertex, 1);
        colored[startVertex] = true;
        coloringOrder.add(startVertex);

        for (int i = 1; i < V; i++) {
            int nextV = -1;
            int maxSaturation = -1;
            int maxDeg = -1;

            for (int v = 0; v < V; v++) {
                if (!colored[v]) {
                    int sat = saturationDegree(v);
                    int deg = G.degree(v);
                    
                    if (sat > maxSaturation) {
                        maxSaturation = sat;
                        maxDeg = deg;
                        nextV = v;
                    } else if (sat == maxSaturation) {
                        if (deg > maxDeg) {
                            maxDeg = deg;
                            nextV = v;
                        }
                    }
                }
            }

            int color = findLowestAvailableColor(nextV);
            colorVertex(nextV, color);
            colored[nextV] = true;
            coloringOrder.add(nextV);
        }
    }

    private int saturationDegree(int v) {
        Set<Integer> neighborColors = new HashSet<>();
        for (int w : G.adj(v)) {
            if (colors[w] != -1) {
                neighborColors.add(colors[w]);
            }
        }
        return neighborColors.size();
    }

    private int findLowestAvailableColor(int v) {
        Set<Integer> neighborColors = new HashSet<>();
        for (int w : G.adj(v)) {
            if (colors[w] != -1) {
                neighborColors.add(colors[w]);
            }
        }
        
        int color = 1;
        while (neighborColors.contains(color)) {
            color++;
        }
        return color;
    }

    private void colorVertex(int v, int color) {
        colors[v] = color;
        if (color > numColors) {
            numColors = color;
        }
    }

    public int color(int v) {
        return colors[v];
    }

    public int numColors() {
        return numColors;
    }

    public List<Integer> coloringOrder() {
        return coloringOrder;
    }

    public boolean validate() {
        for (int v = 0; v < G.V(); v++) {
            if (colors[v] == -1) return false;
            for (int w : G.adj(v)) {
                if (colors[v] == colors[w]) return false;
            }
        }
        return true;
    }
}
