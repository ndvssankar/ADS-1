
public class LinkedList {
	private Node start;
	private Node last;
	private int size;

	public LinkedList() {
		start = null;
		last = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public void pushLeft(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(start);
		if (start == null) {
			last = newNode;
		}
		start = newNode;
		size++;
	}

	public void pushRight(int data) {
		if (start == null) {
			start = new Node(data);
			last = start;
		} else {
			Node temp = new Node(data);
			last.setNextNode(temp);
			last = temp;
		}
		size++;
	}

	public void popLeft() {
		if (start == null) {
			System.out.println("No nodes to remove");
			return;
		}
		if (start != null) {
			start = start.getNextNode();
			size--;
		}
		if (start == null) {
			last = null;
		}
	}

	public void popRight() {
		if (last == null) {
			System.out.println("No nodes to remove");
			return;
		}
		if (start != null) {
			Node temp = start;
			Node prev = null;
			while (temp.getNextNode() != null) {
				prev = temp;
				temp = temp.getNextNode();
			}
			if (prev != null) {
				prev.setNextNode(null);
			} else {
				start = last = null;
			}
			last = prev;
			size--;
		}
	}

	public Node search(int data) {
		Node temp = start;
		while (temp.getNextNode() != null) {
			if (temp.getData() == data)
				return temp;
			temp = temp.getNextNode();
		}
		return null;
	}

	public void remove(int data) {
		Node temp = start;
		Node prev = null;
		while (temp.getNextNode() != null) {
			if (temp.getData() == data) {
				break;
			}
			prev = temp;
			temp = temp.getNextNode();
		}
		if (prev == null)
			popLeft();
		else if (temp.getNextNode() == null) {
			popRight();
		} else {
			prev.setNextNode(temp.getNextNode());
			size--;
		}
	}

	private void reverse(Node prev, Node temp) {
		if (temp.getNextNode() != null) {
			reverse(temp, temp.getNextNode());
			if (prev != null) {
				temp.setNextNode(prev);
			} else {
				last = temp;
			}
		} else {
			start = temp;
			start.setNextNode(prev);
		}
	}

	public void reverse() {
		System.out.println(start);
		reverse(null, start);
		System.out.println(start);
	}

	public String toString() {
		if (start == null) {
			return "Empty linked list";
		} else {
			StringBuffer sb = new StringBuffer();
			Node temp = start;
			while (temp != last) {
				sb.append(temp.getData() + ", ");
				temp = temp.getNextNode();
			}
			sb.append(last.getData());
			return sb.toString();
		}
	}
}