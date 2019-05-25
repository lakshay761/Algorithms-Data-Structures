package snq3;

import java.util.*;

public class S3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "8+2/3+2^1*(1+3)";
		String s2 = "(8+2)/3+2^(1*1+3)";
		System.out.println(infixEval(s));
		System.out.println(infixToPostfix(s2));
		String s3 = "24/32^-";
		String s4 = "-/24^32";
		post123(s3);
		pre123(s4);
		
	}

	public static int priority(char a) {
		if (a == '+' || a == '-') {
			return 1;
		} else if (a == '*' || a == '/') {
			return 2;
		} else if (a == '^') {
			return 3;
		}
		return 0;
	}

	public static int eval(int a, int b, char op) {
		int val = 0;
		if (op == '+') {
			val = a + b;
		} else if (op == '-') {
			val = a - b;
		} else if (op == '*') {
			val = a * b;
		} else if (op == '/') {
			val = a / b;
		} else if (op == '^') {
			val = (int) Math.pow(a, b);
		}
		return val;
	}

	public static int infixEval(String str) {

		Stack<Character> operator = new Stack<>();
		Stack<Integer> value = new Stack<>();
		int val = 0;
		for (int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i));
			if (str.charAt(i) == '(') {
				operator.push(str.charAt(i));

			} else if (str.charAt(i) == ')') {
				while (operator.peek() != '(') {
					char op = operator.pop();
					int b = value.pop();
					int a = value.pop();
					val = eval(a, b, op);
					value.push(val);
				}
				operator.pop();
			} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				value.push(str.charAt(i) - '0');

			} else {
				while (operator.size() > 0 && operator.peek() != '(' && priority(operator.peek()) >= priority(str.charAt(i))
						 ) {
					char op = operator.pop();
					int b = value.pop();
					int a = value.pop();
					val = eval(a, b, op);
					value.push(val);
				}
				operator.push(str.charAt(i));
			}
		}
		while (operator.size() > 0) {
			char op = operator.pop();
			int b = value.pop();
			int a = value.pop();
			val = eval(a, b, op);
			value.push(val);
		}
		return value.peek();
	}
	
	public static String infixToPostfix(String str) {
		String postfix = new String();
		Stack<Character> st = new Stack<>(); 
		
		for(int i=0 ; i<str.length() ; i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				st.push(ch);
			}else if(ch == ')') {
				while(st.peek() != '(') {
					postfix += st.pop();
				}
				st.pop();
			}else if(ch >= '0' && ch <= '9') {
				postfix += ch;
			}else {
				while(st.size() >0 && st.peek() != '(' && priority(st.peek()) >= priority(ch)) {
					postfix += st.pop();
				}
				st.push(ch);
			}
			
		}
		while(st.size()>0) {
			postfix += st.pop();
		}
		
		return postfix;
	}
	
	public static String rev(String str) {
		String s = "";
		for(int i = str.length()-1;i>=0;i--) {
			s +=str.charAt(i);
		}
		return s;
			
	}
	public static String infixToPrefix(String str) {
		String prefix = new String();
//		String nstr = rev();
		
		return prefix;
	}
	
	public static void post123(String str) {
		Stack<Integer> es = new Stack<>();
		Stack<String> is = new Stack<>();
		Stack<String> pres = new Stack<>();

		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') {
				es.push(ch - '0');
				is.push(ch + "");
				pres.push(ch + "");
			}
			else {
				char op = ch;
				int v2 = es.pop();
				int v1 = es.pop();
				int val = eval(v1,v2,op);
				es.push(val);
				String s2 = is.pop();
				String s1 = is.pop();
				is.push("(" + s1 + op + s2 + ")");
				String s4 = pres.pop();
				String s3 = pres.pop();
				pres.push(op + s3 +  s4 + "");
			}
		}
		System.out.println(es.peek());
		System.out.println(is.peek());
		System.out.println(pres.peek());
		
	}

	public static void pre123(String str) {
		Stack<Integer> es = new Stack<>();
		Stack<String> is = new Stack<>();
		Stack<String> pres = new Stack<>();

		for(int i=str.length()-1; i>=0;i--) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') {
				es.push(ch - '0');
				is.push(ch + "");
				pres.push(ch + "");
			}
			else {
				char op = ch;
				int v1 = es.pop();
				int v2 = es.pop();
				int val = eval(v1,v2,op);
				es.push(val);
				String s1 = is.pop();
				String s2 = is.pop();
				is.push("(" + s1 + op + s2 + ")");
				String s3 = pres.pop();
				String s4 = pres.pop();
				pres.push( s3 +  s4 + op+ "");
			}
		}
		System.out.println(es.peek());
		System.out.println(is.peek());
		System.out.println(pres.peek());

	}
	
}
