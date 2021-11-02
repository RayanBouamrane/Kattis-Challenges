#include <iostream>
using namespace std;

bool isKperiodic(string s, int k) {
    if (s.length()%k != 0) return false;

    string sub = s.substr(0, k);

    for (int i = 0; i < s.length(); i+= k) {
        if((s.substr(i,k)) != sub)
            return false;
        sub.insert(0, string(1, sub[k-1]));
        sub = sub.substr(0,k);
    }

    return true;
}

int main() {

    string s;
    cin >> s;

    int k = s.length();
    for (int i = s.length(); i > 0; i--) {
        if(isKperiodic(s, i))
            k = i;
    }
    cout << k;
    return 0;
}