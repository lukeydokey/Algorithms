package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

백준 1991 트리 순회

*/

public class Tree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	public static class Node{
		int value;
		Node left;
		Node right;
		
		
		
		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	static ArrayList<Node> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>(n);
		//노드 생성
		for(int i=0;i<n;i++) {
			list.add(new Node(i));
		}
		
		//노드 연결
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = st.nextToken().charAt(0) - 'A';
			int l = st.nextToken().charAt(0) - 'A';
			int r = st.nextToken().charAt(0) - 'A';
			if(l>=0&&l<=25) {
				list.get(v).left = list.get(l);
			}
			if(r>=0&&r<=25) {
				list.get(v).right = list.get(r);
			}
		} 
		
		preOrder(list.get(0));
		sb.append("\n");
		inOrder(list.get(0));
		sb.append("\n");
		postOrder(list.get(0));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static void preOrder(Node node) {
		char c = (char) ('A' + node.value);
		sb.append(c);
		if(node.left!=null) preOrder(node.left);
		if(node.right!=null) preOrder(node.right);
	}
	static void inOrder(Node node) {
		char c = (char) ('A' + node.value);
		if(node.left!=null) inOrder(node.left);
		sb.append(c);
		if(node.right!=null) inOrder(node.right);
	}
	static void postOrder(Node node) {
		char c = (char) ('A' + node.value);
		if(node.left!=null) postOrder(node.left);
		if(node.right!=null) postOrder(node.right);
		sb.append(c);
	}
}
