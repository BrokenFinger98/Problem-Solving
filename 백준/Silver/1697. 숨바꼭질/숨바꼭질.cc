#include<bits/stdc++.h>
using namespace std;
int N, K, v, cnt;
int visited[100001];
queue<pair<int, int>> q;
void bfs(int u){
    q.push({u, 0});
    visited[u] = 1;
    while (q.size()){
        tie(v, cnt) = q.front();
        q.pop();
        if(v == K){
            cout << cnt << "\n";
            return;
        }
        if(v + 1 >= 0 && v + 1 <= 100000){
            if(!visited[v+1]){
                visited[v+1] = 1;
                q.push({v+1, cnt+1});
            }
        }
        if(v - 1 >= 0 && v - 1 <= 100000){
            if(!visited[v-1]){
                visited[v-1] = 1;
                q.push({v-1, cnt+1});
            }
        }
        if(v * 2 >= 0 && v * 2 <= 100000){
            if(!visited[v*2]){
                visited[v*2] = 1;
                q.push({v*2, cnt+1});
            }
        }
    }
}
int main(){
    cin >> N >> K;
    bfs(N);
    return 0;
}
