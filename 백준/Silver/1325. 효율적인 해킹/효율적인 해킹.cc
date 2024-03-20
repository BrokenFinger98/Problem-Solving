#include<bits/stdc++.h>
using namespace std;
int n, m, cnt;
vector<int> adj[10004];
int visited[10004];
vector<int> ret;
void dfs(int u){
    ++cnt;
    visited[u] = 1;
    for(int v : adj[u]){
        if(visited[v] == 0)
            dfs(v);
    }
    return;
}
int main(){
    cin >> n >> m;
    int u, v;
    for(int i =0;i<m;++i){
        cin >> u >> v;
        adj[v].push_back(u);
    }
    int max_cnt = 0;
    for(int i = 1; i <= n; ++i){
        memset(visited, 0, sizeof(visited));
        cnt = 0;
        dfs(i);
        if(cnt > max_cnt){
            max_cnt = cnt;
            ret.clear();
            ret.push_back(i);
        }else if(cnt == max_cnt){
            ret.push_back(i);
        }
    }
    sort(ret.begin(), ret.end());
    for(int v : ret){
        cout << v << " ";
    }
    return 0;
}