#include<bits/stdc++.h>
using namespace std;
int n;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    vector<int> f;
    f.push_back(1);
    f.push_back(3);
    for(int i = 2; i < n ; ++i){
        f.push_back((f[i-1] + f[i-2]*2)%10007);
    }
    cout << f[n-1];
    return 0;
}