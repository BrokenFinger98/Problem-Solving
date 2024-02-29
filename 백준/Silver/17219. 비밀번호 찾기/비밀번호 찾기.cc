#include<bits/stdc++.h>
using namespace std;
int N, M;
map<string, string> mp;
string s1, s2;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for(int i = 0; i < N; ++i){
        cin >> s1 >> s2;
        mp[s1] = s2;
    }
    for(int i = 0; i < M; ++i){
        cin >> s1;
        cout << mp[s1] << "\n";
    }
}