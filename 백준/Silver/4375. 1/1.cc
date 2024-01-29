#include<bits/stdc++.h>
using namespace std;
int n;
typedef long long ll;
int main(){
    ios_base::sync_with_stdio();
    cin.tie(NULL); cout.tie(NULL);
    while(cin >> n){
        int cnt = 1, ret = 1;
        while(1){
            if(cnt%n == 0){
                cout << ret << "\n";
                break;
            }else{
                cnt = (cnt * 10) + 1;
                cnt %= n;
                ret++;
            }
        }
    }
    return 0;
}