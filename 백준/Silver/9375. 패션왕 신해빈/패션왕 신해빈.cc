#include<bits/stdc++.h>
using namespace std;
int N, M, sum;
string tmp, tmp1;
map<string, int> mp;
int main(){
    cin >> N;
    for(int i = 0; i < N; ++i){
        cin >> M;
        sum = 1;
        for(int j = 0; j < M; ++j){
            cin >> tmp >> tmp1;
            mp[tmp1]++;
        }
        for(auto it : mp){
            sum *= (it.second+1);
        }
        cout << --sum << "\n";
        mp.clear();
    }
}