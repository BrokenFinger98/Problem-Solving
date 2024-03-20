#include<bits/stdc++.h>
using namespace std;
int n, m, ret = INT_MAX;
int mp[50][50];
vector<vector<int>> chickenList;
vector<pair<int, int>> home, chicken;
void combi(int start, vector<int> v){
    if(v.size() == m){
        chickenList.push_back(v);
        return;
    }
    for(int i = start + 1; i < chicken.size(); ++i){
        v.push_back(i);
        combi(i, v);
        v.pop_back();
    }
    return;
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n ;++i){
        for(int j = 0; j < n; ++j){
            cin >> mp[i][j];
            if(mp[i][j] == 2) chicken.push_back({i, j});
            if(mp[i][j] == 1) home.push_back({i, j});
        }
    }
    vector<int> v;
    combi(-1, v);
    for(vector<int> chic : chickenList){
        int min_dist = 0;
        for(pair<int, int> h : home){
            int disOne = INT_MAX;
            for(int ch : chic){
                int sum = abs(chicken[ch].first - h.first) + abs(chicken[ch].second - h.second);
                disOne = min(sum, disOne);
            }
            min_dist += disOne;
        }
        ret = min(min_dist, ret);
    }
    cout << ret << "\n";
}