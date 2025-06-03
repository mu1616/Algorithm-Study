class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir : dirs) {
            if (dir.equals(("")) || dir.equals(".")) {
                continue;
            }
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(dir);
        }
        return "/" + stack.stream()
                .collect(Collectors.joining("/"));
    }
}