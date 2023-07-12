// monte um código em java simples sem utilizar as bibliotecas em que o usuário insere os valores e realiza 
// uma pesquisa na arvore, sem o valor estiver lá, apresenta a posição dele, se não, 
// insere ele na arvore e apresenta

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class ArvorePesquisa {
    static Node root;

    public static void main(String[] args) {
        buildTree();
        System.out.print("Digite o valor a ser pesquisado: ");
        int value = readIntFromUser();

        searchValue(root, value);
    }

    public static void buildTree() {
        root = insertNode();
    }

    public static Node insertNode() {
        System.out.print("Digite o valor do nó (ou -1 para nó nulo): ");
        int value = readIntFromUser();

        if (value == -1) {
            return null;
        }

        Node newNode = new Node(value);

        System.out.println("Inserir nó esquerdo de " + value + ":");
        newNode.left = insertNode();

        System.out.println("Inserir nó direito de " + value + ":");
        newNode.right = insertNode();

        return newNode;
    }

    public static void searchValue(Node node, int value) {
        if (node == null) {
            insertValue(value);
        } else if (value < node.data) {
            if (node.left == null) {
                node.left = new Node(value);
                System.out.println("Valor " + value + " inserido na posição esquerda.");
            } else {
                searchValue(node.left, value);
            }
        } else if (value > node.data) {
            if (node.right == null) {
                node.right = new Node(value);
                System.out.println("Valor " + value + " inserido na posição direita.");
            } else {
                searchValue(node.right, value);
            }
        } else {
            System.out.println("Valor " + value + " já existe na árvore.");
        }
    }

    public static int readIntFromUser() {
        try {
            byte[] buffer = new byte[16];
            System.in.read(buffer);
            String input = new String(buffer).trim();
            return Integer.parseInt(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
