#include <iostream>
#include <string> 
using namespace std;

int sumofdigits(int x) {

    int count = 0;
    string s = to_string(x);
    for (int i = 0; i < s.length(); i++) {
        string j;
        j.push_back(s[i]);
        count += stoi(j);
    }
    return count;
}

int main()
{
     
    long int n;
    
while (cin >> n && n != 0) {
   
  long int dig = sumofdigits(n);
  long int mult = 11;
    while (1) {
        

        
        if (sumofdigits(mult*n) == dig ) {
            cout << mult << "\n";
            break;
        }
        mult++;
    }
}
   return 0;
}
