#include<bits/stdc++.h>
using namespace std;
#define prev aaaa
const int maxS = 200000;
int n, k, now;
int visited[maxS];
int prev[maxS];
queue<int> q;
vector<int> v;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> k;
    visited[n] = 1;
    q.push(n);
    while (q.size()){
        now  = q.front(); q.pop();
        for(int next : {now+1, now-1, now*2}){
            if(next < 0 || next >= maxS || visited[next]) continue;
            visited[next] = visited[now] + 1;
            prev[next] = now;
            q.push(next);
        }
    }
    
    for(int i = k; i != n; i = prev[i])
        v.push_back(i);
    v.push_back(n);
    reverse(v.begin(), v.end());

    cout << visited[k]-1 << "\n";
    for(int a : v) cout << a << " ";
    return 0;
}