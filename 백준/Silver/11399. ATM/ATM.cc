#include<bits/stdc++.h>
using namespace std;
int N, e, minTime = 1000005, sum;
int a[1001];
int b[1001];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> N;
    for(int i = 1; i <= N; ++i){
        cin >> a[i];
    }
    sort(&a[1], &a[N+1]);
    for(int i = 1; i <= N; ++i){
        sum += a[i];
        b[i] = sum;
    }
    sum = 0;
    for(int i = 1; i <= N; ++i)
        sum += b[i];
    cout << sum;
}