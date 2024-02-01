#include<bits/stdc++.h>
using namespace std; 
int n, cnt, ret;
int main(){
    ios_base::sync_with_stdio();
    cin.tie(NULL); cout.tie(NULL);
    while (cin >> n){
        cnt = 1;
        ret = 1;
        while (1){
            if((ret %= n) == 0){
                cout << cnt << "\n";
                break;
            }
            ++cnt;
            ret *= 10;
            ++ret;
        }
    }
}