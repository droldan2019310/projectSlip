package maps;

import java.util.HashMap;

import interfaces.IMap;
/**

 A class that implements the IMap interface using a HashMap to store key-value pairs.

 @param <V> the type of the values to be stored in the HashMap
 */
public class HashMapClass<V> implements IMap<V> {
    HashMap<String,V> variables = new HashMap<String, V>();

    /**

     Adds a new key-value pair to the HashMap.
     @param key the key to be added
     @param value the value to be associated with the key
     @return true if the key-value pair was added successfully, false otherwise
     */
    @Override
    public boolean add(String key, V value) {
        // TODO Auto-generated method stub
        try {
            variables.put(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**

     Retrieves the value associated with a given key from the HashMap.
     @param key the key to retrieve the value for
     @return the value associated with the key, or null if the key is not present in the HashMap
     */
    @Override
    public V getValue(String key) {
        // TODO Auto-generated method stub
        return variables.get(key);
    }
    /**

     Removes a key-value pair from the HashMap.
     @param key the key to be removed
     */
    @Override
    public void remove(String key) {
        // TODO Auto-generated method stub
        variables.remove(key);
    }
    
}
