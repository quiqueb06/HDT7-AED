class Node<E> {
    E data;
    Node<E> left, right;

    public Node(E data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    // Método para insertar
    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> root, E data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Método para buscar
    public E search(E data) {
        Node<E> result = searchRec(root, data);
        return result != null ? result.data : null;
    }

    private Node<E> searchRec(Node<E> root, E data) {
        if (root == null || root.data.compareTo(data) == 0) {
            return root;
        }
        if (root.data.compareTo(data) > 0) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    // Recorrido In-Order
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<E> root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
}