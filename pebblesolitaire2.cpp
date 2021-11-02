#include <iostream>
#include <unordered_map>

using namespace std;

unordered_map<string, int> map;
int globalMin;

int countPebbles(string pebbles) {
        int n = 0;
        for (int i = 0; i < 23; i++) {
            if (pebbles[i] == 'o')
                n++;
        }
        return n;
    }

int leastNumber(string pebbles, int n) {
    
    if (map.find(pebbles) != map.end()) { return map[pebbles]; }
    
    for (int i = 1; i < 22; i++) {
        if(pebbles[i] == 'o') {
            if (pebbles [i-1] == '-' && pebbles[i+1] == 'o') {
                string tempPebblesL = pebbles;
                tempPebblesL[i-1] = 'o';
                tempPebblesL[i] = '-';
                tempPebblesL[i+1] = '-';
                map[pebbles] = leastNumber(tempPebblesL, n - 1);
            }
            if (pebbles[i-1] == 'o' && pebbles[i+1] == '-') {
                string tempPebblesR = pebbles;
                tempPebblesR[i-1] = '-';
                tempPebblesR[i] = '-';
                tempPebblesR[i+1] = 'o';
                map[pebbles] = leastNumber(tempPebblesR, n - 1);
            }
        }
    }

    return globalMin = min(globalMin, n);
    
}

int main() {
   int iters;
   cin >> iters;
   
   for (int i = 0; i < iters; i++) {
        globalMin = 23;
        string s;
        cin >> s;
        cout << leastNumber(s, countPebbles(s)) << "\n";
        map.clear();
   }
   
   return 0;
}