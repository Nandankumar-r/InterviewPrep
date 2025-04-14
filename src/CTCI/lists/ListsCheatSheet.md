# 📘 Linked List Interview Cheat Sheet

## 🔁 Core Traversal Patterns

| **Pattern**                       | **When to Use**                            | **Examples**       |
|----------------------------------|--------------------------------------------|--------------------|
| **Two Pointers (Slow & Fast)**   | Detect cycles, find middle, kth from end   | 2.2, 2.6, 2.8      |
| **Dummy Head + Tail Pointers**   | Partitioning, merging, building new lists  | 2.4                |
| **Recursive Backtracking**       | Sum in forward order, palindrome check     | 2.5 (forward), 2.6 |
| **Stack**                         | Reverse compare, tracking visited          | 2.6                |
| **HashSet / HashMap**            | Detect duplicates, cycles, visited nodes   | 2.1, 2.8 (brute)   |
| **Length + Tail Matching**       | Find intersection                          | 2.7                |

---

## ⚙️ Algorithms by Problem Type

| **Problem Type**     | **Strategy**                                 | **Notes**                                     |
|----------------------|----------------------------------------------|-----------------------------------------------|
| **Remove Duplicates**| Use HashSet                                  | O(n) time, O(n) space                         |
| **Kth to Last Element**| Two-pointer gap technique                  | Maintain `k` node gap                         |
| **Delete Middle DSAMustSolve.Node**| Copy next node data into current            | No access to previous node                    |
| **Partition List**    | Two separate lists (before & after pivot)   | Merge at end                                  |
| **Sum Lists**         | Track carry, use recursion for forward sum  | Padding needed                                |
| **Check Palindrome**  | Use stack or recursion                      | Also solvable with list reversal              |
| **Find Intersection** | Compare tails, align length difference      | O(n + m)                                      |
| **Detect Loop**       | Floyd’s Cycle Detection (Tortoise & Hare)   | O(n) time, O(1) space                         |
| **Find Loop Start**   | Head + meet-point traversal sync            | They meet at loop start                       |

---

## 🧠 Ninja-Level Insights

- Reversing a list is fundamental — do it iteratively and recursively.
- Recursive solutions need to pass back both the node pointer AND status/result — use a wrapper class!
- In intersection problems, if the tail nodes differ by reference, they can’t intersect. Period.
- For palindrome check with recursion — use length to find the midpoint and track matching on unwind.
- You can "simulate" pointer rollback (like in recursion) using a stack if recursion isn’t viable.

---

## 🧪 Must Know for Interviews

- Cycle detection is a pattern that reappears in graph problems.
- In-place list reversal is the basis of reversing half the list, rotating, etc.
- Most pointer-based problems need strong diagramming skills — draw before code.
- Know how to restore a list after modifying (re-reverse, reconnect).
- Linked list bugs are almost always off-by-one or null-pointer related — dry-run with 2–3 nodes always.

---

## 🪄 Real-World Application Mapping

| **Concept**         | **Where It’s Used**                                |
|---------------------|----------------------------------------------------|
| **Two pointers**     | TCP congestion control, slow logs, pagination     |
| **Loop detection**   | Memory leak diagnosis, linked data structures     |
| **Partitioning**     | QuickSort, garbage collectors                     |
| **Intersection**     | Merging dependency trees, branch analysis         |
| **Recursive matching**| DNA palindrome detection, backtracking engines |

---

## 📌 Final Pattern Codex Entries Learned

✅ **Two Pointers**  
✅ **Dummy Head**  
✅ **In-place Reversal**  
✅ **Recursive Tracking with Wrapper**  
✅ **Cycle Detection (Floyd’s)**  
✅ **Tail/Length-Based Intersection Detection**  
✅ **Stack-Based Reverse Matching**
