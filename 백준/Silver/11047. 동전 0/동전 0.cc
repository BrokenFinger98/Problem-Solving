#include<bits/stdc++.h>
using namespace std;
int N, K, cnt, sum, ans;
int coin[10];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> N >> K;
    for(int i = 0; i < N; ++i)
        cin >> coin[i];
    for(int i = N -1; i >= 0; --i){
        cnt = (K-sum)/coin[i];

        ans += cnt;
        sum += cnt*coin[i];
    }
    cout << ans;
}