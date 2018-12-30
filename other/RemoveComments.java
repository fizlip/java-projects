import java.util.Stack;

class RemoveComments{

    Stack<Character> commentStack = new Stack<>();

    public String removeComments(String line){
        if(line.length() == 0){
            return null;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < line.length(); i++){
            if(i < line.length() - 1){
                if(line.charAt(i) == '/' && line.charAt(i+1) == '*'){
                    commentStack.push(line.charAt(i));
                }
                if(line.charAt(i) == '*' && line.charAt(i+1) == '/'){
                    commentStack.pop();
                    i++;
                    continue;
                }
            }
            // Only add character if there is no active comment.
            if(commentStack.size() == 0){
                result.append(line.charAt(i));
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        RemoveComments rm = new RemoveComments();
        String uncomment = "Hello /* This /* is a */ comment */";
        System.out.println(rm.removeComments(uncomment));
    }

}