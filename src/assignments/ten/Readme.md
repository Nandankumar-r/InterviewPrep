Classic DP Patterns (Your List)
1. 0/1 Knapsack
   Concept:

In the 0/1 Knapsack problem, each item can either be chosen (1) or not chosen (0) under a capacity constraint.
The goal is to maximize (or sometimes minimize) a value (like profit or weight) while not exceeding the capacity.
State Representation:

DP[i][w]: The optimal value achievable with the first i items and a capacity w.
Decisions are binary: include an item or skip it.
Transitions:

For each item, decide whether to include it:
Include: If the item’s weight is less than or equal to the remaining capacity, update:
DP[i][w] = max(DP[i][w], DP[i-1][w - weight[i]] + value[i])
Exclude:
DP[i][w] = DP[i-1][w]
Common Problems:

Standard 0/1 Knapsack.
Variants that deal with profit maximization or cost minimization under capacity constraints.
Nuances:

Requires careful initialization.
Optimizations such as space reduction using a one-dimensional array are often possible.
2. Unbounded Knapsack
   Concept:

Unlike the 0/1 Knapsack, here you can use an item an unlimited number of times.
This pattern is used when the same item can be picked repeatedly to maximize the value.
State Representation:

DP[w]: The best value achievable with capacity w.
You iterate over capacities and items without the binary restriction.
Transitions:

For each capacity w and item i:
DP[w] = max(DP[w], DP[w - weight[i]] + value[i])
(if w >= weight[i])
Common Problems:

Unbounded Knapsack.
Coin Change (making change with unlimited coins).
Nuances:

Order of iteration matters to allow multiple uses of the same item.
Often implemented with a single array.
3. Shortest Path (e.g., Unique Paths I/II)
   Concept:

These problems often involve finding the number of ways or the minimum cost to traverse a grid or graph from one point to another.
The grid is typically processed cell by cell.
State Representation:

DP[i][j]: For grid problems like Unique Paths, it might represent the number of ways to reach cell (i, j).
Transitions:

Transitions come from neighboring cells:
For Unique Paths:
DP[i][j] = DP[i-1][j] + DP[i][j-1] (if only right and down moves are allowed)
Common Problems:

Unique Paths I/II (counting paths with or without obstacles).
Minimum Path Sum problems.
Nuances:

Boundary conditions must be carefully handled.
Often uses iterative (bottom-up) DP for clarity.
4. Fibonacci Sequence (e.g., House Thief, Jump Game)
   Concept:

Many problems reduce to a recurrence similar to the Fibonacci sequence, where the current state depends on one or two previous states.
This pattern is seen in problems with limited and sequential dependencies.
State Representation:

DP[i]: For instance, the maximum amount of money that can be stolen up to house i.
Often only the last few states are needed.
Transitions:

For the Fibonacci sequence:
DP[i] = DP[i-1] + DP[i-2]
For problems like House Thief:
DP[i] = max(DP[i-1], DP[i-2] + value[i])
Common Problems:

Fibonacci numbers.
House Thief (House Robber).
Jump Game variants.
Nuances:

Often optimized with constant space.
Recurrences are straightforward and easy to reason about.
5. Longest Common Substring/Subsequence
   Concept:

These problems involve comparing two sequences (strings, arrays) to find common patterns.
They can be used for similarity, error correction, or alignment tasks.
State Representation:

DP[i][j]: For Longest Common Subsequence (LCS), it represents the length of the LCS of the first i characters of one string and the first j characters of the other.
For Longest Common Substring, similar definitions are used with the constraint of contiguous elements.
Transitions:

For LCS:
If characters match:
DP[i][j] = DP[i-1][j-1] + 1
Else:
DP[i][j] = max(DP[i-1][j], DP[i][j-1])
For Longest Common Substring, the transition resets the count when characters do not match.
Common Problems:

Longest Common Subsequence.
Longest Common Substring.
Variants including edit distance and sequence alignment.
Nuances:

Initialization (first row and column) is crucial.
Often enhanced with space optimizations.
Additional DP Patterns
6. Bitmask DP
   Concept:

Used when the state involves choosing a subset of items.
A bitmask encodes the subset, where each bit indicates whether an element is included (1) or not (0).
State Representation:

DP[mask][i]: For example, in the Traveling Salesman Problem (TSP), the state is defined by:
mask: A bitmask representing visited cities.
i: The last visited city.
Transitions:

Iterate over items not yet included in the mask and update the state by setting the corresponding bit.
Common Problems:

Traveling Salesman Problem.
Assignment Problems where the choice of subsets is key.
Nuances:

Time complexity is exponential (commonly O(2ⁿ * n)), practical for small n.
Efficient bit manipulation is essential.
7. Interval DP
   Concept:

Applied to problems where decisions are made on intervals or segments of an array/string.
It involves partitioning or merging intervals to optimize a function.
State Representation:

DP[i][j]: Represents the optimal solution for the interval from index i to j.
Transitions:

For an interval
[
𝑖
,
𝑗
]
[i,j], try splitting at every possible index k:
DP[i][j] = combine(DP[i][k], DP[k+1][j])
Often involves iterating over increasing interval lengths.
Common Problems:

Matrix Chain Multiplication.
Burst Balloons.
Palindrome Partitioning.
Nuances:

Requires nested loops for interval length, start index, and splitting index.
Correct initialization of base cases (e.g., intervals of length 1) is critical.
8. Tree DP
   Concept:

Used on tree structures, where a node’s state depends on the states of its children.
The solution is typically computed in a postorder fashion (processing children before their parent).
State Representation:

DP[node]: The optimal solution for the subtree rooted at that node.
May include multiple states per node (e.g., including vs. excluding the node).
Transitions:

Combine the DP values of the children to compute the state for the current node.
Decisions might involve taking the node’s value or skipping it to maximize/minimize a value.
Common Problems:

Maximum Independent Set in a tree.
Tree Diameter.
Path Sum problems on trees.
Nuances:

Recursive DFS is often used.
Ensure that each node is processed only once to avoid re-computation.
9. Digit DP
   Concept:

Specialized for problems that involve digit-level constraints (e.g., counting numbers that satisfy specific conditions).
It operates on a digit-by-digit basis.
State Representation:

DP[pos][tight][state]:
pos: Current digit position.
tight: Indicates whether the current prefix matches the prefix of an upper bound (affecting the range of valid digits).
state: Additional conditions (e.g., sum of digits, remainder).
Transitions:

For each digit position, iterate over all possible digits (0–9) respecting the “tight” condition.
Update the state and adjust the tight flag as needed.
Common Problems:

Counting numbers with a given digit sum.
Counting numbers without repeated digits.
Problems involving specific digit patterns.
Nuances:

The “tight” parameter is crucial to limit choices.
Typically implemented with recursion and memoization.
10. Longest Increasing Subsequence (LIS) and Its Variants
    Concept:

Focuses on finding the longest subsequence where elements are in increasing order.
Although a classic DP problem, it has specialized optimized approaches.
State Representation:

DP[i]: Length of the longest increasing subsequence ending at index i.
Alternatively, maintain a separate list of candidate values for an efficient O(n log n) solution.
Transitions:

For each element, check previous elements:
DP[i] = max(DP[i], DP[j] + 1) for all j where array[j] < array[i].
Common Problems:

Standard Longest Increasing Subsequence.
Maximum Sum Increasing Subsequence.
Variants that modify the criteria (e.g., non-decreasing instead of strictly increasing).
Nuances:

The optimized solution uses binary search to maintain a candidate list.
Easy to extend for related sequence problems.
11. DP with Monotonic Data Structures
    Concept:

Optimizes transitions over ranges or windows using monotonic queues or deques.
The goal is to efficiently retrieve the best candidate (max or min) over a sliding window.
State Representation:

DP[i]: Represents the optimal solution up to index i.
A monotonic data structure (queue/deque) maintains candidates in sorted order.
Transitions:

As you move through indices, update the monotonic data structure by removing expired elements and inserting the current DP state.
Use the data structure to quickly determine the optimal state for the next transition.
Common Problems:

Constrained Subsequence Sum.
Sliding Window Maximum/Minimum problems.
Nuances:

Maintaining the monotonic property during insertions and removals is key.
This approach can reduce time complexity significantly (e.g., from O(n²) to O(n)).
12. Subset DP
    Concept:

A broader category where the state is defined by a subset of items.
While Bitmask DP is one implementation, subset DP can also refer to problems where subsets are iterated over in different ways.
State Representation:

DP[mask]: Represents the optimal solution for the subset encoded by the bitmask.
The state may also be represented by actual sets if the problem size permits.
Transitions:

Iterate over subsets or submasks and update the DP state by combining or extending subsets.
Often involves iterating over all submasks of a given mask to merge results.
Common Problems:

Minimum Vertex Cover in a Graph.
Set Partitioning Problems.
Variants of the Traveling Salesman Problem.
Nuances:

The number of states grows exponentially, so these methods are practical only when the total number of elements is small.
Efficient iteration over submasks is critical.
Summary
Dynamic programming problems are diverse, and many share common structures that can be grouped into these patterns:

Classic Patterns:

0/1 Knapsack & Unbounded Knapsack: Focus on item selection with/without repetition.
Shortest Path (Unique Paths): Traverse grids/graphs by building up from neighboring states.
Fibonacci Sequence Patterns: Use limited sequential dependencies.
Longest Common Substring/Subsequence: Compare sequences to find optimal matching.
Additional Patterns:

Bitmask DP & Subset DP: Manage and iterate over subsets efficiently.
Interval DP: Tackle problems on contiguous segments.
Tree DP: Leverage hierarchical structures in trees.
Digit DP: Address digit-level constraints in number problems.
Longest Increasing Subsequence (LIS): Focus on ordering and sequence optimization.
DP with Monotonic Data Structures: Optimize range-based transitions using specialized queues.
Understanding these patterns helps you map a problem’s requirements to a familiar framework, guiding you in defining states, transitions, and optimizations to design efficient DP solutions.