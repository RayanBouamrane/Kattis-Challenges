#include <iostream>
#include <map>
#include <string>
using namespace std;

int main() {
	int n;
	cin >> n;
	map<string, int> history;
	string str;
	for (int i = 0; i < n; i++) {
	    cin >> str;
	    string temp = "";
	    for (string::iterator it = str.begin(); it!=str.end(); it++) {
	        temp += *it;
	        if (history.end() == history.find(temp)) { history[temp] = 1; }
	        else { history[temp]++; }
	    }
	    cout << history[temp] -1 << "\n";
	}
	return 0;
}