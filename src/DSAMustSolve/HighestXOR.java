package DSAMustSolve;

import java.util.*;

public class HighestXOR {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        Trie trie = new Trie(nums);
        System.out.println(trie.findMaximumXOR(nums));  // Output: 28
    }
}

// Node representing each bit (0 or 1) in the Trie
class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }

    Node get(int bit) {
        return links[bit];
    }
}

// Trie to store binary representations of numbers
class Trie {
    Node root;
    int bitLength; // Highest bit position based on max number in nums

    public Trie(int[] nums) {
        root = new Node();
        bitLength = getBitLength(nums);
        for (int num : nums) {
            insert(num);
        }
    }

    // Get bit length needed (e.g., max bit position from highest number)
    private int getBitLength(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        return Integer.toBinaryString(maxNum).length();  // e.g., 25 => "11001" => 5
    }

    // Insert number into Trie (bit by bit)
    private void insert(int num) {
        Node node = root;
        for (int i = bitLength - 1; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    // For each number, find the one in Trie that gives max XOR
    public int findMaximumXOR(int[] nums) {
        int maxXOR = 0;
        for (int num : nums) {
            Node node = root;
            int currentXOR = 0;

            for (int i = bitLength - 1; i >= 0; i--) {
                int bit = (num >> i) & 1;
                // Try to find the complementary bit to maximize XOR
                if (node.containsKey(1 - bit)) {
                    currentXOR |= (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            maxXOR = Math.max(maxXOR, currentXOR);
        }
        return maxXOR;
    }
}
