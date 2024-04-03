#include<bits/stdc++.h>
using namespace std;
int n, k, m, v;
long long ret;
vector<pair<int, int>> a;
vector<int> b;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> k;
    for(int i = 0; i < n; ++i){
        cin >> m >> v;
        a.push_back({m, v});
    }
    for(int i = 0; i < k; ++i){
        cin >> m;
        b.push_back(m);
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    priority_queue<int> pq;
    int j = 0;
    for(int i = 0; i < k; ++i){
        while (j < n && a[j].first <= b[i]) pq.push(a[j++].second);
        if(pq.size()){
            ret += pq.top(); pq.pop();
        }
    }
    cout << ret << "\n";
    return 0;
}
