# 📘 Stacks & Queues Interview Cheat Sheet

## 🔁 Core Traversal Patterns

| **Pattern**                    | **When to Use**                               | **Examples**       |
|-------------------------------|-----------------------------------------------|--------------------|
| **Two Stacks = One Queue**     | Simulate FIFO using LIFO                      | CTCI 3.4           |
| **Two Queues = One Stack**     | Simulate LIFO using FIFO                      | CTCI 3.7           |
| **Stack with Min/Max**         | Track minimum/maximum in O(1)                 | CTCI 3.2           |
| **Sort with Stack**            | Sort stack using another stack                | CTCI 3.5           |
| **Stack of Stacks (Set of Stacks)** | Group stacks with threshold capacity        | CTCI 3.3           |
| **Backtracking/Simulation**    | Tree/graph traversal, undo/redo               | Expression parsing |
| **Monotonic Stack/Queue**      | Sliding window, next greater/smaller element | Leetcode-style     |
| **Circular Queue**             | Fixed-size queues (e.g., I/O buffer)          | System design      |
| **BFS Queue**                  | Level-order traversal                         | Graph/tree search  |

---

## ⚙️ Algorithms by Problem Type

| **Problem Type**     | **Strategy**                                  | **Problem**     |
|----------------------|-----------------------------------------------|------------------|
| Simulate Multiple Stacks | Fixed division or flexible shifting       | CTCI 3.1         |
| Track Min in Stack   | Use a second minStack or node min snapshot    | CTCI 3.2         |
| Stack Threshold Logic| Split stacks into bounded-size sets           | CTCI 3.3         |
| Queue via Stacks     | Lazy transfer using two stacks                | CTCI 3.4         |
| Sort a Stack         | Use another stack for insertion-sort style    | CTCI 3.5         |
| Animal Shelter Queue | Timestamped queue with type filtering         | CTCI 3.6         |
| Stack via Queues     | Rotate elements in two queues                 | CTCI 3.7         |

---

## 🧠 Ninja-Level Insights

- Push logic to the **cheapest path**: stack = push O(1), queue = enqueue O(1)
- Stack reversal = one temp stack (inversion)
- Queue FIFO behavior = **two stacks** → lazy transfer (amortized O(1))
- Use **timestamping** when priority/FIFO must be preserved across types
- Avoid using arrays unless explicitly allowed
- Use **extra stack or queue** instead of array sorting when constrained

---

## 🪄 Real-World Application Mapping

| **Concept**             | **Real-World Use Case**                             |
|--------------------------|-----------------------------------------------------|
| Stack with min/max       | Browser back button with tab priority               |
| Two-stack queue          | Asynchronous I/O message queues                     |
| Queue via stack          | Postfix evaluation using only FIFO systems          |
| Sort stack               | Memory management during depth-first resource load  |
| Animal shelter           | Hospital triage queue with patient type preference  |
| Stack of stacks          | File versioning with page overflow control          |
| Backtracking             | Solvers (Sudoku, maze, recursion tree)              |

---

## 📌 Final Pattern Codex Entries Learned

✅ Two-Stack Queue  
✅ Queue-from-Stacks  
✅ Stack-with-Min  
✅ Stack Sort (using another stack)  
✅ Backtracking/Recursion Simulation  
✅ BFS Queue  
✅ Monotonic Stack  
✅ Set of Stacks

