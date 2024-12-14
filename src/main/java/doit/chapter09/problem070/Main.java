package doit.chapter09.problem070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

  private static final Map<String, Node> tree = new HashMap<>();
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        String[] inputs = br.readLine().split(" ");
        String parent = inputs[0];
        String left = inputs[1];
        String right = inputs[2];
        tree.putIfAbsent(parent, new Node(parent));
        Node parentNode = tree.get(parent);

        if (!left.equals(".")) {
          tree.putIfAbsent(left, new Node(left));
          parentNode.left = tree.get(left);
        }

        if (!right.equals(".")) {
          tree.putIfAbsent(right, new Node(right));
          parentNode.right = tree.get(right);
        }
      }
      Node root = tree.get("A");
      preOrder(root);
      sb.append("\n");
      inOrder(root);
      sb.append("\n");
      postOrder(root);

      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void preOrder(Node node) {
    if (Objects.isNull(node)) {
      return;
    }
    sb.append(node.value);
    preOrder(node.left);
    preOrder(node.right);
  }

  private static void inOrder(Node node) {
    if (Objects.isNull(node)) {
      return;
    }
    inOrder(node.left);
    sb.append(node.value);
    inOrder(node.right);
  }

  private static void postOrder(Node node) {
    if (Objects.isNull(node)) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    sb.append(node.value);
  }

  private static class Node {

    String value;
    Node left;
    Node right;

    public Node(String value) {
      this.value = value;
    }
  }

}