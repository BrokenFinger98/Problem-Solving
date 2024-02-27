#include<bits/stdc++.h>
using namespace std;
int N, M, u, v, cnt;
vector<int> adj[1001];
int visited[1001];
void dfs(int u){
    for(int there : adj[u])
        if(visited[there] == 0){
            visited[there] = 1;
            dfs(there);
        }
}
int main(){
    cin >> N >> M;
    for(int i = 0; i < M; ++i){
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for(int i = 1; i <= N ; ++i){
        if(visited[i] == 0){
            dfs(i);
            ++cnt;
        }
    }
    cout << cnt << "\n";
    return 0;
}
