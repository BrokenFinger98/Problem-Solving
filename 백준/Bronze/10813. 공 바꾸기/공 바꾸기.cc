#include<bits/stdc++.h>
using namespace std;
int n, m, a, b, temp;
int bas[101];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i <= n; ++i){
        bas[i] = i;
    }
    for(int i = 0; i < m; ++i){
        cin >> a >> b;
        temp = bas[a];
        bas[a] = bas[b];
        bas[b] = temp;
    }
    for(int i = 1; i <= n; ++i) cout << bas[i] << " ";
    return 0;
}