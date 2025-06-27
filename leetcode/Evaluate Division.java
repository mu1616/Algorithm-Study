class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> calculateMap = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            calculateMap.putIfAbsent(equation.get(0), new HashMap<>());
            calculateMap.get(equation.get(0)).put(equation.get(1), values[i]);

            calculateMap.putIfAbsent(equation.get(1), new HashMap<>());
            calculateMap.get(equation.get(1)).put(equation.get(0), 1 / values[i]);

            graph.putIfAbsent(equation.get(0), new HashSet<>());
            graph.get(equation.get(0)).add(equation.get(1));

            graph.putIfAbsent(equation.get(1), new HashSet<>());
            graph.get(equation.get(1)).add(equation.get(0));
            i++;
        }

        double[] result = new double[queries.size()];
        for (i = 0; i < queries.size(); i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            result[i] = calculateQuery(s1, s2, calculateMap, graph);
        }
        return result;
    }

    private double calculateQuery(String s1, String s2, Map<String, Map<String, Double>> calculateMap, Map<String, Set<String>> graph) {
        if (graph.containsKey(s1) && s1.equals(s2)) {
            return 1;
        }       
        Queue<Value> queue = new LinkedList<>();
        queue.add(new Value(s1, 1));
        Set<String> visited = new HashSet<>();
        visited.add(s1);

        while (!queue.isEmpty()) {
            Value value = queue.poll();

            for (String s : graph.getOrDefault(value.s, Set.of())) {
                if (visited.contains(s)) {
                    continue;
                }
                if (s.equals(s2)) {
                    return value.n * calculateMap.get(value.s).get(s);
                }
                queue.add(new Value(s, value.n * calculateMap.get(value.s).get(s)));
                visited.add(s);
            }
        }
        return -1;
    }

    public static class Value {
        String s;

        double n;

        public Value(String s, double n) {
            this.s = s;
            this.n = n;
        }
    }
}