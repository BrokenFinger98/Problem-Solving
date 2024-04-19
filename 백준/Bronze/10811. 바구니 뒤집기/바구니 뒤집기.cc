#include<bits/stdc++.h>
using namespace std;
int n, m, a, b;
vector<int> v;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i <= n; ++i){
        v.push_back(i);
    }
    for(int i = 0; i < m; ++i){
        cin >> a >> b;
        reverse(v.begin()+a, v.begin()+b+1);
    }
    for(int i = 1; i <= n; ++i) cout << v[i] << " ";
    return 0;
}