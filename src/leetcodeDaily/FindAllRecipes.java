package leetcodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllRecipes {
    public static void main(String[] args) {
        FindAllRecipes obj = new FindAllRecipes();
        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = new ArrayList<>(Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "meat"),
                Arrays.asList("sandwich", "meat", "bread")
        ));
        String[] supplies = {"yeast", "flour", "meat"};
        System.out.println(obj.findAllRecipesDfs(recipes, ingredients, supplies));
    }

    public List<String> findAllRecipesBfs(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();

        HashSet<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));  // Quick lookup for available ingredients
        HashMap<String, List<String>> graph = new HashMap<>(); // To track dependent recipes as an ingredient
        HashMap<String, Integer> indegree = new HashMap<>(); // To track required number of ingredients

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, 0);

            for (String ingredient : ingredients.get(i)) {
                if (!suppliesSet.contains(ingredient)) {
                    graph.putIfAbsent(ingredient, new ArrayList<>());
                    graph.get(ingredient).add(recipe);
                    indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
                }
            }
        }
        System.out.println("Indegree Map: " + indegree);

        Queue<String> queue = new LinkedList<>();
        for (String recipe : recipes) {
            if (indegree.get(recipe) == 0) {
                queue.offer(recipe);
            }
        }

        while (!queue.isEmpty()) {
            String cookedRecipe = queue.poll();
            res.add(cookedRecipe);

            // Reduce the indegree of other recipes which are dependent on this cookedRecipe
            if (graph.containsKey(cookedRecipe)) {
                for (String dependent : graph.get(cookedRecipe)) {
                    indegree.put(dependent, indegree.get(dependent) - 1);
                    if (indegree.get(dependent) == 0) {
                        queue.offer(dependent);
                    }
                }
            }
        }

        return res;
    }

    public List<String> findAllRecipesDfs(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> suppliesSet = new HashSet<>(Arrays.asList(supplies)); // Quick lookup for available ingredients
        HashMap<String, List<String>> graph = new HashMap<>(); // Map to track recipe -> ingredients
        HashMap<String, Boolean> memo = new HashMap<>(); // Optimization for already computed recipe

        for (int i = 0; i < recipes.length; i++) {
            graph.put(recipes[i], ingredients.get(i));
        }

        List<String> res = new ArrayList<>();

        for (String recipe : recipes) {
            if (canMake(recipe, graph, suppliesSet, memo, new HashSet<>())) {
                res.add(recipe);
            }
        }
        return res;
    }

    private boolean canMake(String recipe, HashMap<String, List<String>> graph, HashSet<String> supplies, HashMap<String, Boolean> memo, HashSet<String> visited) {
        if (memo.containsKey(recipe)) return true;

        if (supplies.contains(recipe)) return true;

        if (visited.contains(recipe)) return false;

        if (!graph.containsKey(recipe)) return false;

        for (String ingredient : graph.get(recipe)) {
            if (!canMake(ingredient, graph, supplies, memo, visited)) {
                memo.put(recipe, false);
                return false;
            }
        }

        memo.put(recipe, true);
        return true;
    }
}