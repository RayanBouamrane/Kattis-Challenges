#include <iostream>
#include <cstdlib>

using namespace std;

void getClosestSum (int nNumbers[], int size, int querry) {
    
    int currentClosest = nNumbers[0] +nNumbers[1];
        
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && (abs(nNumbers[i] + nNumbers[j] - querry) < abs(currentClosest - querry))) {
                        currentClosest = nNumbers[i] + nNumbers[j]; 
                }
            }   
        }
    cout << "Closest sum to " << querry << " is " << currentClosest << ".\n";
}


int main()
{
    int curCase = 0;
    int n;
    
    while (cin >> n) {
        curCase++;
        
        cout << "Case " << curCase << ":\n";
        
        int numbers [n];
        for (int i = 0; i < n; i++) {
            int t;
            cin >> t;
            numbers[i] = t; 
            // cout << numbers[i] <<"\n";
        }
        
        int m;
        cin >> m;
        // cout << m << "\n";
        int curQuerry;
        for (int i = 0; i < m; i++) {
            cin >> curQuerry;
            // cout << curQuerry << "\n";
            getClosestSum(numbers, n, curQuerry);
            
        }
    }
    return 0;
}