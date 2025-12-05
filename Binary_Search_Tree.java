// Author: Arash Heidarzadeh Naeini


class TreeNode {
    int key;  // Integer key to hold the node's value
    TreeNode left, right;  // Pointers to the left and right child nodes

    // Constructor to create a new node with a given key
    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class Binary_Search_Tree {
    TreeNode root;  // Root of the binary search tree

    // Constructor to initialize the binary search tree with no initial root
    Binary_Search_Tree() {
        root = null;
    }

    // Public method to insert a new key in the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive helper method to insert a new key in the BST at the correct position
    private TreeNode insertRec(TreeNode root, int key) {
        // Base case: if the subtree is empty, create a new node and return it
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        // If the key to insert is less than the current node's key, recurse on the left subtree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } 
        // If the key to insert is greater than the current node's key, recurse on the right subtree
        else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // Return the unchanged node pointer
        return root;
    }

    // Method to perform pre-order traversal of the BST (root, left, right)
    void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");  // Visit the root node
            preOrder(node.left);              // Traverse the left subtree
            preOrder(node.right);             // Traverse the right subtree
        }
    }

    // Method to perform post-order traversal of the BST (left, right, root)
    void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);            // Traverse the left subtree
            postOrder(node.right);           // Traverse the right subtree
            System.out.print(node.key + " ");  // Visit the root node
        }
    }

    // Method to count and print the leaf nodes in the BST
    int countAndPrintLeafNodes(TreeNode node) {
        if (node == null) {
            return 0;  // Return 0 if the node is null
        }
        // Check if the node is a leaf node
        if (node.left == null && node.right == null) {
            System.out.print(node.key + " ");  // Print leaf node
            return 1;  // Return count as 1
        }
        // Recursive call to left and right subtree and sum their leaf counts
        return countAndPrintLeafNodes(node.left) + countAndPrintLeafNodes(node.right);
    }

    public static void main(String[] args) {
        
        // Clearing the screen
        System.out.print("\u000c");

        Binary_Search_Tree tree = new Binary_Search_Tree();
        int[] keys = {50, 27, 16, 88, 34, 65, 52, 77, 93, 4, 12, 29, 44, 92};
        // Inserting nodes into the BST
        for (int key : keys) {
            tree.insert(key);
        }

        // Perform and display pre-order traversal
        System.out.print("Pre-order traversal: ");
        tree.preOrder(tree.root);
        System.out.println();

        // Perform and display post-order traversal
        System.out.print("Post-order traversal: ");
        tree.postOrder(tree.root);
        System.out.println();

        // Print and count leaf nodes
        System.out.print("Leaf nodes: ");
        int leafCount = tree.countAndPrintLeafNodes(tree.root);
        System.out.println("\nTotal leaf nodes: " + leafCount);
    }
}









