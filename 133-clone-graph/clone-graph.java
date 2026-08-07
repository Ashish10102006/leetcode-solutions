/*
Whenever you see:
Graph
Cycles
Need to create a copy
Think:
Traverse the graph (DFS or BFS).
Create a new node for each original node.
Use a HashMap<Original, Clone> so each node is cloned exactly once.
Connect the cloned neighbors.
This is the standard pattern for graph cloning.
*/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if( node == null ) return null;

        if(map.containsKey(node)) return map.get(node);

        Node clone =new Node(node.val);
        map.put(node,clone);

        for (Node nei : node.neighbors) {
            clone.neighbors.add(cloneGraph(nei));
        }
        return clone;
    }
}
/*
Step 1: Understand the problem
You are given a node in a connected graph.
You must create a completely new graph with the same structure.
Example:
Original
1 ---- 2
|      |
|      |
4 ---- 3
Clone should be
1' ---- 2'
|        |
|        |
4' ---- 3'
Notice:
Node 1 and 1' are different objects.
Connections are exactly the same.

Step 2: The challenge
Suppose you clone node 1.
Then you visit neighbor 2.
While cloning 2, you again see neighbor 1.
If you keep creating new nodes,
1
↓
2
↓
1
↓
2
↓
1
...
Infinite recursion.

So we need to remember
"Have I already cloned this node?"

Step 3: Use a HashMap
Original Node  →  Cloned Node

1              → 1'
2              → 2'
3              → 3'
4              → 4'

Whenever we visit a node,
If already in map
return cloned node
Otherwise
create clone
store in map
clone neighbors

Step 4: DFS Algorithm
For every node
Clone(node)
if node == null
    return null

if already cloned
    return cloned node

create clone

store in hashmap

for every neighbor
      clone neighbor
      add cloned neighbor
return clone

Step 5: Dry Run
Start with node 1
Clone(1)
Create 1'
Map
1 → 1'
Neighbors:
2
4
Go to 2.
Clone(2)
Create 2'
Map
1 → 1'
2 → 2'
Neighbors
1
3
Neighbor = 1
Already exists
return 1'
No new node created.
Go to 3.
Clone(3)
Create 3'
Map
1 → 1'
2 → 2'
3 → 3'
Neighbor
2
4
2 already cloned
Return 2'
Go to 4.
Clone(4)
Create 4'
Map
1 →1'
2 →2'
3 →3'
4 →4'
Neighbors
1
3
Both already cloned.
Return 4'

Done.
*/