#include<bits/stdc++.h>
using namespace std;
int N, M, V, u, v;
vector<int> adj[1004];
int visited[1004];
queue<int> q;
void dfs(vector<int> *adj, int *visited, int u){
    visited[u] = 1;
    cout << u << " ";
    for(int it : adj[u]){
        if(visited[it]) continue;
        dfs(adj, visited, it);
    }
    return;
}
void bfs(vector<int> *adj, int *visited, int u){
    visited[u] = 1;
    q.push(u);
    while (q.size()){
        v = q.front();
        q.pop();
        cout << v << " ";
        for(int it : adj[v]){
            if(visited[it]) continue;
            visited[it]++;
            q.push(it);
        }
    }
}
int main(){
    cin >> N >> M >> V;
    vector<int> adj[N+2];
    int visited[N+2];
    for(int i = 0; i < M; ++i){
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for(int i = 0; i < N; ++i){
        sort(adj[i+1].begin(), adj[i+1].end());
    }
    memset(visited, 0, sizeof(visited));
    dfs(adj, visited, V);
    memset(visited, 0, sizeof(visited));
    cout << "\n";
    bfs(adj, visited, V);
    return 0;
}