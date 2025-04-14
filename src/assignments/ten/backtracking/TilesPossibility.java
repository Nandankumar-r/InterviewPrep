package assignments.ten.backtracking;

import java.util.HashSet;

public class TilesPossibility {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }

    public static int numTilePossibilities(String tiles) {
        HashSet<String> uniqueSet = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        backtrack(tiles, "", uniqueSet, used);
        return uniqueSet.size();
    }

    private static void backtrack(String tiles, String current, HashSet<String> uniqueSet, boolean[] used) {
        if (!current.isEmpty()) {
            uniqueSet.add(current);
        }

        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(tiles, current + tiles.charAt(i), uniqueSet, used);
                used[i] = false;
            }
        }
    }
}
