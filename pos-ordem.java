// monte um código em java simples sem utilizar as bibliotecas em que o usuário insere os valor e apresente em arvore em pos-ordem

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

public class ArvorePosOrdem {
    static Node root;

    public static void main(String[] args) {
        buildTree();
        System.out.println("Árvore em Ordem (Pós-Ordem):");
        postOrderTraversal(root);
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

    public static void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
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
