import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    //file dosyasının bulunmasında sıkıntı olabilir, kesin yolu kopyalarak sorunun üstesinden geldim.
    static File file = new File("src/sources");

    public static void main(String[] args) throws FileNotFoundException {
        NodeOperations operations = new NodeOperations();
        Scanner reader = new Scanner(file);
        int nodeCount = nodeCounter(), column = 0;
        Node[] nodeHeads = new Node[nodeCount];
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            String[] list = line.split("->|/");
            for (int item = 0; item < list.length; item = item + 2){
                if(item == 0){
                    nodeHeads[column] = new Node(list[item], Integer.parseInt(list[item + 1]));
                }else {
                    nodeHeads[column] = NodeOperations.addNode(nodeHeads[column], new Node(list[item], Integer.parseInt(list[item + 1])));
                }
            }
            column++;
        }
        operations.adjacencyListPrinter(nodeHeads); //test passed
        operations.degreePrinter(nodeHeads, 42);
        System.out.println(operations.edgeCounter(nodeHeads));
        operations.whereToGo(nodeHeads, 34);
        operations.cameCityFrom(nodeHeads, 42);
    }

    /**
     * @return Returns the number of nodes in the graph.
     */
    public static int nodeCounter() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int nodeCounter = 0;
        while (reader.hasNextLine()){
            reader.nextLine();
            nodeCounter++;
        }
        return nodeCounter;
    }
}