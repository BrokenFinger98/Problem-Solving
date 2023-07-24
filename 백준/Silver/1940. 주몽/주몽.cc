#include<bits/stdc++.h>
using namespace std;
int x[15000], N, M, cnt;
int main(){
    cin >> N >> M;
    for(int i = 0; i < N; ++i) cin >> x[i];
    sort(x, x+N);
    for(int i = 0; i < N; ++i){
        if(x[i] > M)
            break;
        for(int j = i+1; j < N; ++j){
            if(x[i] + x[j] == M)
                ++cnt;
        }
    }
    cout << cnt << '\n';
}
