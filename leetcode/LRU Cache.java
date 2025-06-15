class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }

        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }

        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.keySet().iterator().next());
        }
    }
}