#include <bits/stdc++.h>
using namespace std;
int pos, cnt;
string s;
string l[8] = {
    "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
};
int main(){
    cin >> s;
    for(int i = 0; i < 8; ++i){
        while (1){
            auto it = s.find(l[i]);
            if(it == string::npos){
                break;
            }
            s.replace(it, l[i].length(), "a");
        }
    }
    cout << s.length() << "\n";
    return 0;
}