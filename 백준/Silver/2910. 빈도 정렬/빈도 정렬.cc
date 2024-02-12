#include<bits/stdc++.h>
using namespace std;
int n, c;
int a[1004];
vector<pair<int, int>> ret;
map<int, int> mp, mp1;
bool cmp(pair<int, int> a, pair<int, int> b){
    if(a.first == b.first)
        return mp1[a.second] < mp1[b.second];
    return a.first > b.first;
}
int main(){
    cin >> n >> c;
    for(int i = 0; i < n; ++i){
        cin >> a[i];
        mp[a[i]]++;
        if(mp1[a[i]] == 0) mp1[a[i]] = i + 1;
    }
    for(auto it : mp){
        ret.push_back({it.second, it.first});
    }
    sort(ret.begin(), ret.end(), cmp);
    for(auto it : ret){
        for(int i = 0; i < it.first; ++i)
            cout << it.second << " ";
    }
    return 0;
}