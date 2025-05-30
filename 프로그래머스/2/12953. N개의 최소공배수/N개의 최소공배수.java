class Solution {
    int gca(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    // int gca(int a, int b) {
    //     if (b == 0) {
    //         return a;
    //     }
    //     return gca(b, a % b);
    // }
    
    int lcm(int a, int b) {
        return a * b / gca(a, b);
    }
    
    public int solution(int[] arr) {
        int temp = lcm(arr[0], arr[1]);
        
        for (int a : arr) {
            temp = lcm(temp, a);
        }
        return temp;
    }
}