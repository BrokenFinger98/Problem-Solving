#include<bits/stdc++.h>
using namespace std;
int n;
int main(){
    cin >> n;
    vector<int> f;
    f.push_back(1);
    f.push_back(2);
    for(int i = 2; i < n ; ++i){
        f.push_back((f[i-1] + f[i-2])%10007);
    }
    cout << f[n-1];
    return 0;
}