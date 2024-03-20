#include<bits/stdc++.h>
using namespace std;
int n, m, result = 50000;
int mp[50][50];
vector<vector<int>> chickenList;
vector<pair<int, int>> home, chicken;
void combi(int start, vector<int> v){
    if(v.size() == m){
        chickenList.push_back(v);
        return;
    }
    for(int i = start+1; i < chicken.size(); ++i){
        v.push_back(i);
        combi(i, v);
        v.pop_back();
    }
    return;
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> mp[i][j];
            if(mp[i][j] == 2) chicken.push_back({i, j});
            if(mp[i][j] == 1) home.push_back({i, j});
        }
    }
    vector<int> v;
    combi(-1, v);
    for(vector<int> list : chickenList){
        int ret = 0;
        for(pair<int, int> h : home){
            int min_dist = 50000;
            for(int ch : list){
                int sum = abs(h.first - chicken[ch].first) + abs(h.second - chicken[ch].second);
                min_dist = min(sum, min_dist);
            }
            ret += min_dist;
        }
        result = min(result, ret);
    }
    cout << result << "\n";
    return 0;
}
