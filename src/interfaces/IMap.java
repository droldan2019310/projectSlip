package interfaces;

public interface IMap<V> {
    
    public boolean add(String key, V value);

    public V getValue(String key);

    public void remove(String key);


}
