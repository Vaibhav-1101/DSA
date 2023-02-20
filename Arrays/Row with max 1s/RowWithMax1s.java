
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int i = 0;
        int elements = n * m;
        int count = 0;
        int result = -1;
        int max = 0;
        while (i < elements) {
            if (arr[i / m][i % m] == 1) {
                count++;
            }
            if ((i % m) == (m - 1)) {
                if (count > max) {
                    max = count;
                    result = i / m;
                }
                count = 0;
            }
            i++;
        }
        return result;
    }
}