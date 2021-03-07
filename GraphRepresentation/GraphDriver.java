
import java.util.Arrays;

/**
 * CISC 380
 * Algorithms BFS Example
 * Driver File for the Graph class.
 * 
 * @author Keith O'Neal
 */



public class GraphDriver{

   

    /**
    * Creates a simple graph with 2 vertices connected by a single edge.
    * @return a simple graph with two nodes
    */
    public static Graph createSimpleGraph(){

        int[][] list = { {1},
                         {0} 
                        };

        Graph graph = new Graph(list);
    
        return graph;
    }//createSimpleGraph


    
    public static Graph createUnaryTree(int size){

        boolean[][] list = new boolean[size][size];

        for(int i = 1; i < size; i++){
            list[i-1][i] = true;
            list[i][i-1] = true;
        }

        return new Graph(list);

    }
 
    /**
     * Creates a graph representation of a binary tree with the given amount of nodes.
     * @return a graph with a binary tree
     */
    public static Graph createBinaryTree(int numNodes){

        boolean[][] matrix = new boolean[numNodes][numNodes];

        for(int i = 0; i < numNodes; i++ ){
            if( (2*i + 1) < numNodes ){
                matrix[i][2*i + 1] = true;
                matrix[2*i + 1][i] = true;
            }
            //if the right child is present, add it
            if( (2*i + 2) < numNodes ){
                matrix[i][2*i + 2] = true;
                matrix[2*i + 2][i] = true;
            }
        }

        Graph graph = new Graph(matrix);

        return graph;
    }//createBinaryTree

    public static Graph createForest(int numTrees, int treeSize){
        int numNodes = numTrees * treeSize;
        boolean[][] matrix = new boolean[numNodes][numNodes];

        for(int i = 0; i < numTrees; i++){

            for(int j = 0; j < treeSize-1; j++){
                matrix[(i*treeSize) + j][(i*treeSize)+j+1] = true;
                matrix[(i*treeSize)+j+1][(i*treeSize) + j] = true;
            }

        }

        return new Graph(matrix);

    }//createForest

    public static Graph createAcyclicGraph(int numNodes){


        boolean[][] matrix = new boolean[numNodes][numNodes];

        for(int i = 0; i < numNodes-1;i++){
            matrix[i][i+1] = true;
            matrix[i+1][i] = true;

        }

        return new Graph(matrix);
    }//createAcyclicGraph

    public static Graph createCyclicGraph(int numNodes){
       
        boolean[][] matrix = new boolean[numNodes][numNodes];

        for(int i = 0; i < numNodes-1;i++){
           matrix[i+1][i] = true;
           matrix[i][i+1] = true;

        }

        if(numNodes > 2){
            matrix[numNodes-1][0] = true;
            matrix[0][numNodes-1] = true;
        }
        
        return new Graph(matrix);

    }//createAcyclicGraph

    /**
     * creates a graph with one vertex shared between two trees.
     * 
     * 
     */
    public static Graph createDisconnectedGraph(){

        int[][] list = 
        {
            {1,3},
            {0,2},
            {1},
            {0, 4},
            {3},
            {6},
            {5}
        };
        return new Graph(list);
    }

    public static void main(String[] args){

        Graph graph = GraphDriver.createDisconnectedGraph();
        //Graph graph = GraphDriver.createCyclicGraph(10);
        //Graph graph = GraphDriver.createSimpleGraph();
        //Graph graph = GraphDriver.createForest(2, 4);
        //Graph graph = GraphDriver.createBinaryTree(12);

        System.out.println("Graph Representation: \n" + graph.toString());
        // System.out.println("Roots: " + graph.findRoots().toString());

        int start = 0;
        int[] dist = new int[7];
        int[] prev = new int[7];

        for (int i = 0; i < dist.length; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }


        graph.BFS(start, dist, prev);
        System.out.println("Dist: " + Arrays.toString(dist));
        System.out.println("Prev: " + Arrays.toString(prev));

    }//main



}//class