#include<bits/stdc++.h>
using namespace std;
#define prev BrokenFinger
int n, A, B, team, asum, bsum;
string s, prev;
string print(int a){
    string h = "00" + to_string(a/60);
    string m = "00" + to_string(a%60);
    return h.substr(h.size()-2, 2) + ":" + m.substr(m.size()-2, 2);
}
int change(string s){
    return atoi(s.substr(0, 2).c_str())*60 + atoi(s.substr(3, 2).c_str());
}
void go(int &sum, string s){
    sum += (change(s) - change(prev));
}
int main(){
    cin >> n;
    for(int i = 0; i < n; ++i){
        cin >> team >> s;
        if(A>B) go(asum, s);
        else if(B>A) go(bsum, s);
        team == 1 ? ++A : ++B;
        prev = s;
    }
    if(A>B) go(asum, "48:00");
    else if(B>A) go(bsum, "48:00");
    cout << print(asum) << "\n";
    cout << print(bsum) << "\n";
}

