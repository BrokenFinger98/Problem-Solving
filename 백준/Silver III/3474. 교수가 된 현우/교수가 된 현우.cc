#include<bits/stdc++.h>
using namespace std;
int T, N, cnt1, cnt2;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> T;
    for(int i = 0; i < T; ++i){
        cin >> N;
        cnt1 = 0;
        cnt2 = 0;
        for(int j = 2; j <= N; j *= 2)
            cnt1 += N/j;
        for(int j = 5; j <= N; j*= 5)
            cnt2 += N/j;
        cout << min(cnt1, cnt2) << "\n";
    }
    return 0;
}