#include<bits/stdc++.h>
using namespace std; 
const int MAX = 100001;
int n, k, now, next, e;
int visited[MAX+4], pre[MAX+4];
queue<int> q;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> k;
    if(n == k){
        cout << 0 << "\n";
        cout << n << "\n";
        return 0;
    }
    visited[n] = 1;
    pre[n] = n;
    q.push(n);
    while (q.size()){
        now = q.front(); q.pop();
        if(now == k)
            break;
        for(int next : {now-1, now+1, now*2}){
            if(next < 0 || next > MAX) continue;
            if(!visited[next]){
                visited[next] = visited[now] + 1;
                pre[next] = now;
                q.push(next);
            }
        }
    }

    vector<int> v;
    v.push_back(k);
    for(int i = k; i != n; i = pre[i])
        v.push_back(pre[i]);
    reverse(v.begin(), v.end());

    cout << visited[k] - 1 << "\n";
    for(int a : v)
        cout << a << " ";
    cout << "\n";
    return 0;
}