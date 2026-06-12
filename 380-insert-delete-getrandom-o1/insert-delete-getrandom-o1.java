// We need:
// Fast search → HashMap
// Fast random access → ArrayList

class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer,Integer> map;

    public RandomizedSet() {
        list= new ArrayList<>();
        map=new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        // Move last element to deleted position
        list.set(index, last);
        map.put(last, index);
        // 1. Take the last element of the array.
        // 2. Put that last element in the position of the element you want to remove.
        // 3. Delete the last element (the duplicate).

        // Remove last element
        list.remove(list.size() - 1);

        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int index = (int)(Math.random() * list.size());
        return list.get(index);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */