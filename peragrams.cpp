#include <iostream>
#include <string>

using namespace std;

int main()
{
    string s;
    cin >> s;

    int alph[26] = { 0 };

    for (int i = 0; i < s.length(); i++) {
        int c = s[i];
        alph[c - 97]++;
    }
    int rem = 0;

    for (int i = 0; i < 26; i++) {
        if (alph[i] != 0) {
            if (alph[i] % 2 != 0) {
                rem++;
            }
        }
    }
    if (rem == 0)
        cout << 0 << "\n";
    else
        cout << rem - 1 << "\n";

    return 0;
}