class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int product = 1 , i = list.size()-1;
        while(k > 0){
            product *= list.get(i--);
            k--;
        }
        return product;
    }
}