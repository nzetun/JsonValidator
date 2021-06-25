package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @editor nzetocha
 * 
 * A basic JSON validator. This validator only checks that the JSON file is
 * well-balanced: that all opening brackets have a corresponding closing bracket
 * and that they follow legal nesting rules.
 * 
 */
public class JsonValidator {

	public static boolean isValidJSON(String jsonString) {
		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new Queue<Character>();
		boolean result = false;
		int length = jsonString.length();
		for(int i=0; i<length; i++) {
			char c = jsonString.charAt(i);
			if(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')') {
				if(i < length/2) {
					stack.push(c);
				} else if(i >= length/2) {
					queue.enqueue(c);
				}
			}
		}
		if(stack.isEmpty() || queue.isEmpty() || stack.size() != queue.size()) {
			result = false;
		} else {
			while(!stack.isEmpty() && !queue.isEmpty()) {
				char a = stack.pop();
				char b = queue.dequeue();
				if(a == '{' && b == '}' || a == '[' && b == ']' || a == '(' && b == ')') {
					result = true;
				} 
			}
		}
		if(!stack.isEmpty() || !queue.isEmpty()) {
			result = false;
		}
		return result;
		
	}

	public static String getFileContents(String fileName) {
		StringBuilder sb = new StringBuilder();
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		while (s.hasNextLine()) {
			sb.append(s.nextLine());
		}
		s.close();
		return sb.toString();
	}

	public static void main(String[] args) {
		String jsonFileName = "data/data001.json";
		String jsonString = getFileContents(jsonFileName);
		System.out.println(isValidJSON(jsonString) ? "Valid" : "Invalid");
	}
}
