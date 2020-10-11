//이진탐색트리
//root보다 큰 노드는 오른쪽으로, 작은 노드는 왼쪽에 위치한다.
//정렬된 데이터를 bst에 삽입하게 된다면 Linked List 형태가 되므로 BST의 장점을 취하기 어렵다.

class Node {
	int key;
	Node left;
	Node right;
}

Node root = root;

//재귀
public void insert(Node root, Node node) {	
	if(root.key > node.key) {
		if(root.left != null)
			insert(root.left, node);
		else
			root.left = node;
		
	} else {
		if(root.right != null)
			insert(root.right, node);
		else
			root.right = node;
	}
}

//while문
public void insert(int key) {
    if (findNode(key) != null) return;  // 이미 존재하면 그냥 리턴

    Node newNode = new Node(key);

    if (root == null) {
        root = newNode; // 트리가 비어있으면 root 에 삽입
    } else {
        Node focusNode = root;  //  탐색용 노드
        Node parent;            //  탐색용 노드의 부모 노드

        while(true) {
            parent = focusNode; //  이동

            if (key < parent.key) {             //  삽입하려는 키가 현재 노드보다 작으면
                focusNode = parent.leftChild;   //  왼쪽으로 이동

                if (focusNode == null) {        //  왼쪽 노드가 비어있으면
                    parent.leftChild = newNode; //  왼쪽 노드에 삽입
                    return;
                }
            } else {                            //  삽입하려는 키가 현재 노드와 같거나 크다면
                focusNode = parent.rightChild;  //  오른쪽으로 이동

                if (focusNode == null) {        //  오른쪽 노드가 비어있으면
                    parent.rightChild = newNode;//  오른쪽 노드에 삽입
                    return;
                }
            }
        }
    }
}

public void find() {
	//insert와 비슷
}

//전위순회 (부모노드 -> 왼쪽 자식노드 -> 오른쪽 자식노드) == 하위트리의 root를 먼저 방문 == DFS
public void preOrder(Node node) {
	if(node == null)
		return;
	
	System.out.println(node.key);
	
	preOrder(node.left);
	preOrder(node.right);
}

//후위순회 (왼쪽 자식노드 -> 오른쪽 자식노드 -> 부모노드) == 하위트리의 root를 마지막에 방문
public void postOrder(Node node) {
	if(node == null)
		return;
	
	postOrder(node.left);
	postOrder(node.right);
	
	System.out.println(node.key);
}