#include<bits/stdc++.h>
using namespace std;
int N, M, ret;
string s;
map<string, int> mp;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for(int i = 0; i < N; ++i){
        cin >> s;
        mp[s]++;
    }
    for(int i = 0; i < M; ++i){
        cin >> s;
        mp[s]++;
    }
    for(auto it : mp){
        if(it.second == 2)
            ++ret;
    }
    cout << ret << "\n";
    for(auto it : mp){
        if(it.second == 2)
            cout << it.first << "\n";
    }
}