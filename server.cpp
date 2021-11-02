#include <iostream>
#include <sstream>

using namespace std;

int main()
{
    
    int num, totaltime;
    cin >> num >> totaltime;
    
    int count = 0;
    
    for (int i = 0; i < num; i++) {
        
        int t;
        cin >> t;
        if (totaltime - t >= 0) {
            totaltime -= t;
            count++;
        } else {
            break;
        }
        
    }
    
    cout << count;
}