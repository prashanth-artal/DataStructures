package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
public class TreeProblems {
	
	public static TreeNode createBST(int[] arr,int st, int end) {
		if(st>end) {
			return null;
		}
		
		int mid = st + (end -st)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createBST(arr,st,mid -1);
		node.right = createBST(arr,mid+1,end);
		
		return node;
	}
	
	public static void levelOrderTraversal(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		int cnt1 =1;
		while(true) {
			if(queue.isEmpty()) {
				break;
			}
			int cnt2 =0;
			while(cnt1 > 0) {
				if(queue.isEmpty()) {
					break;
				}
				
				TreeNode n = queue.poll();
				System.out.print(n.val+" ");
				cnt1--;
				
				if(n.left!=null) {
					queue.add(n.left);
					cnt2++;
				}
				
				if(n.right!=null) {
					queue.add(n.right);
					cnt2++;
				}
			}
			System.out.println();
			cnt1 =cnt2;
		}
		System.out.println();
	}
	
	public static void preOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		System.out.print("PreOrder: ");
		while(!stack.isEmpty()) {
			TreeNode node =stack.pop();
			System.out.print(node.val+" ");
			
			if(node.right!=null) {
				stack.push(node.right);
			}
			
			if(node.left!=null) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}
	
	public static void inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		System.out.print("InOrder : ");

		while(curr!=null || !stack.isEmpty()) {
			while(curr!=null) {
				stack.push(curr);
				curr =curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.val+" ");
			curr = curr.right;
		}
		
		System.out.println();

	}
	
	public static void postOrder(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			stack2.push(node);
			
			if(node.left!=null) {
				stack1.push(node.left);
			}
			
			if(node.right!=null) {
				stack1.push(node.right);
			}
		}
		
		System.out.print("PostOrder: ");
		while(!stack2.isEmpty()) {
			TreeNode  node = stack2.pop();
			System.out.print(node.val+" ");
		}
	}
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		TreeNode root = createBST(arr,0,arr.length-1);
		levelOrderTraversal(root);
		preOrder(root);
		inOrder(root);
		postOrder(root);
	}
}
