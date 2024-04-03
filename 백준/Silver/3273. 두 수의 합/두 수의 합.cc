#include<bits/stdc++.h>
using namespace std;
int n, x, i, j = 1, ret, flag;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; ++i) cin >> v[i];
    cin >> x;
    sort(v.begin(), v.end());

    int k = n;
    for(int i = 0; i < n; ++i){
        for(int j = i+1; j < k; ++j){
            if(v[i] + v[j] == x){
                k = j;
                ++ret;
                break;
            }
        }
        if(j == k){
            break;
        }
    }
    cout << ret << "\n";
    return 0;
}