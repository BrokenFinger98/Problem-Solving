#include<bits/stdc++.h>
using namespace std;
int n, temp, r, root;
vector<int> adj[50];
int dfs(int u){
    int ret = 0;
    int child = 0;
    for(int v : adj[u]){
        if(v == r) continue;
        ret += dfs(v);
        child++;
    }
    if(child == 0) return 1;
    return ret;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; ++i){
        cin >> temp;
        if(temp == -1) root = i;
        else adj[temp].push_back(i);
    }
    cin >> r;
    if(r == root){
        cout << 0 << "\n";
        return 0;
    }
    cout << dfs(root) << "\n";
}