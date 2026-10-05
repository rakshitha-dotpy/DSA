class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        for (Node child : root.children) {
            result.addAll(postorder(child));
        }

        result.add(root.val);

        return result;
    }
}