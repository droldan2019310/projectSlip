package maps;

import java.util.HashMap;

import interfaces.IMap;

public class HashMapClass<V> implements IMap<V> {
    HashMap<String,V> variables = new HashMap<String, V>(); 
    
    
    
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

    @Override
    public V getValue(String key) {
        // TODO Auto-generated method stub
        return variables.get(key);
    }

    @Override
    public void remove(String key) {
        // TODO Auto-generated method stub
        variables.remove(key);
    }
    
}
