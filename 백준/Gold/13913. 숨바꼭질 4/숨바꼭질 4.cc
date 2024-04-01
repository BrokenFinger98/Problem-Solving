#include<bits/stdc++.h>
using namespace std;
int n, k, ret, now;
int visited[200000];
int prev_[200000];
queue<int> q;
vector<int> v;
void bfs(){
    visited[n] = 1;
    q.push(n);
    while (q.size()){
        now = q.front();
        q.pop();
        if(now == k){
            ret = visited[k];
            break;
        }
        for(int next : {now-1, now+1, now*2}){
            if(next < 0 || next >= 200000 || visited[next]) continue;
            visited[next] = visited[now] + 1;
            prev_[next] = now;
            q.push(next);
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> k;

    bfs();
    for(int i = k; i != n; i = prev_[i])
        v.push_back(i);
    v.push_back(n);
    reverse(v.begin(), v.end());

    cout << ret-1 << "\n";
    for(int b : v)
        cout << b << " ";
    return 0;
}