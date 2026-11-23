class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            list.clear();
            list.add(1);
        }
        else list.add(list.get(list.size()-1) * num);
    }
    
    public int getProduct(int k) {
        int n = list.size()-1;
        if(k > n) return 0;
        return list.get(n) / list.get(n-k);
    }
}

// class ProductOfNumbers {
//     List<Integer> list;
//     public ProductOfNumbers() {
//         list = new ArrayList<>();
//     }
    
//     public void add(int num) {
//         list.add(num);
//     }
    
//     public int getProduct(int k) {
//         int product = 1 , i = list.size()-1;
//         while(k > 0){
//             product *= list.get(i--);
//             k--;
//         }
//         return product;
//     }
// }