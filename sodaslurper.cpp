#include <iostream>

using namespace std;



int main()
{
   
   int a,b,c;
  
   cin >> a >> b >> c;
   
   int empty = a + b;
   int price = c;
   int drunk = 0;

   while (empty - price >= 0) {
          empty -= price; 
          drunk++;
          empty++;
    }
   
    cout << drunk;
    return 0;
}