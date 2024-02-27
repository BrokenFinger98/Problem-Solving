#include<bits/stdc++.h>
using namespace std;
int N, M, ret, u, v;
vector<int> adj[104];
int visited[104];
void dfs(int u){
    visited[u] = 1;
    for(int there : adj[u]){
        if(visited[there] == 0){
            ret++;
            dfs(there);
        }
    }
}
int main(){
    cin >> N;
    cin >> M;
    for(int i = 0; i < M; ++i){
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    dfs(1);
    cout << ret << "\n";
    return 0;
}