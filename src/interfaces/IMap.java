package interfaces;
/**

 An interface for a Map data structure that stores key-value pairs.

 @param <V> the type of the values stored in the map
 */
public interface IMap<V> {
    /**

     Adds a new key-value pair to the map.
     @param key the key associated with the value
     @param value the value to be stored
     @return true if the addition was successful, false otherwise
     */
    public boolean add(String key, V value);
    /**

     Retrieves the value associated with the specified key.
     @param key the key associated with the value to be retrieved
     @return the value associated with the key, or null if the key is not found in the map
     */
    public V getValue(String key);
    /**

     Removes the key-value pair associated with the specified key from the map.
     @param key the key associated with the key-value pair to be removed
     */
    public void remove(String key);


}
