#include<bits/stdc++.h>
using namespace std; 
string s, boom, ret;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> s >> boom;
    for(char a : s){
        ret += a;
        if(ret.size() >= boom.size() && ret.substr(ret.size() - boom.size()) == boom)
            ret.erase(ret.size() - boom.size(), boom.size());
    }
    if(ret.size())
        cout << ret << "\n";
    else
        cout << "FRULA" << "\n"; 
    return 0;
}
