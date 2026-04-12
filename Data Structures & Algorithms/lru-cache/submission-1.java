class LRUCache {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
    }
        };
    }
    
    public int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}
