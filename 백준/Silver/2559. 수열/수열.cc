#include<bits/stdc++.h>
using namespace std;
int a, b, c, psum[100001], ret = -1000000;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);cout.tie(NULL);
    cin >> a >> b;
    for(int i = 1; i <= a; ++i){
        cin >> c;
        psum[i] = psum[i-1] + c;
    }
    for(int i = b; i <= a; ++i){
        ret = max(ret, psum[i] - psum[i-b]);
    }
    cout << ret <<'\n';
}