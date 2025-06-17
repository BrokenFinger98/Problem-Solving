import java.util.*;

class Solution {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			if(stack.isEmpty()){
				stack.push(c);
				continue;
			}else{
				if(c == '('){
					stack.push(c);
				}else{
					if(stack.peek() == '(')
						stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
}