#include<bits/stdc++.h>
using namespace std;
int n, m, ret;
string s, s1;
map<string, int> mp;
int main(){
    cin >> n;
    for(int i = 0; i < n; ++i){
        cin >> m;
        for(int j = 0; j < m; ++j){
            cin >> s >> s1;
            mp[s1]++;
        }
        ret = 1;
        for(auto it : mp){
            ret *= it.second+1;
        }
        ret--;
        cout << ret << '\n';
        mp.clear();
    }
}
