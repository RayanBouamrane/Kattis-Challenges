#include <iostream>
#include <string>

using namespace std;

int mymod(int x, int mod){
    int temp = x%mod;
    if (temp >= 0) 
        return temp;
    else 
        return temp+mod;
}

string  timeformat(int h, int m, int s) {
    
    string fin;
    if (h<10) { fin.append("0"); }
    
    fin.append(to_string(h) + ":");
    
    if (m<10) { fin.append("0"); }
    
    fin.append(to_string(m) + ":");
    
    if (s<10) { fin.append("0"); }
    
    fin.append(to_string(s));
    
    return fin;
}

int main()
{
    
    string line1, line2;
    cin >> line1 >> line2;

    int startH = stoi(line1.substr(0, 2));
    int startM = stoi(line1.substr(3, 2));
    int startS = stoi(line1.substr(6, 2));
    int endH = stoi(line2.substr(0, 2));
    int endM = stoi(line2.substr(3, 2));
    int endS = stoi(line2.substr(6, 2));
    
    int timerS = 0;
    int timerM = 0; 
    int timerH = 0;
    
    timerS = mymod(endS-startS, 60);
    if (endS < startS) endM--;
    timerM = mymod(endM-startM, 60);
    
    if (endM < startM) endH--;
    timerH = mymod(endH-startH, 24);
    
    if (startH == endH && startM == endM && endS == startS) {
        timerH += 24;
    }
    
    cout << timeformat(timerH,timerM, timerS);

    return 0;
}