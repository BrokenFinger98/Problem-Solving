#include<bits/stdc++.h>
using namespace std;
int t, n;
int go(int n){
    int cnt = 0;
    for(int j = 5; j <= n; j*=5)
        cnt += n/j;
    return cnt;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> t;
    for(int i = 0; i < t; ++i){
        cin >> n;
        cout << go(n) << "\n";
    }
}

