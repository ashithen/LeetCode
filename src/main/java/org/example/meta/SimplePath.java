package org.example.meta;

import java.util.Stack;

public class SimplePath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> validPaths = new Stack<>();
        validPaths.push("");

        for (String dir : dirs){
            if (dir.isBlank() || dir.equals(".")){
                continue;
            }
            else if (dir.equals("..")){
                if (!validPaths.isEmpty()){
                    validPaths.pop();
                }
            }
            else {
                validPaths.push(dir);
            }
        }
        return "/"+String.join("/", validPaths);
    }

    public static void main(String[] args) {
        System.out.println(new SimplePath().simplifyPath(".."));
    }
}
