// monte um código em java em que o usuário insere os valor e apresente de forma em arvore em pre-ordem

import java.util.Scanner;

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

public class ArvorePreOrdem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println("Árvore em Pré-Ordem:");
        preOrderTraversal(root);
    }

    public static Node buildTree() {
        System.out.print("Digite o valor do nó (ou -1 para nó nulo): ");
        int value = scanner.nextInt();

        if (value == -1) {
            return null;
        }

        Node newNode = new Node(value);

        System.out.println("Inserir nó esquerdo de " + value + ":");
        newNode.left = buildTree();

        System.out.println("Inserir nó direito de " + value + ":");
        newNode.right = buildTree();

        return newNode;
    }

    public static void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
