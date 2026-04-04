class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0 , j = 0 , n = fruits.length , maxLen = 0;
        while(j < n){
            if(map.containsKey(fruits[j])) map.put(fruits[j] , map.get(fruits[j]) + 1);
            else  map.put(fruits[j] , 1);
            j++;

            while(map.size() > 2){
                int x = fruits[i];
                if(map.get(x) == 1) map.remove(x);
                else map.put(x , map.get(x) - 1);
                i++;
            }

            maxLen = Math.max(maxLen , j-i);
        }
        return maxLen;
    }
}