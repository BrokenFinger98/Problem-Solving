#include<bits/stdc++.h>
using namespace std;
int n, s = 666;
string tmp;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    while(n){
        tmp = to_string(s);
        if(tmp.find("666") != string::npos)
            --n;
        ++s;
    }
    cout << tmp << "\n";
}