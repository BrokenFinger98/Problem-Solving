#include <bits/stdc++.h>
using namespace std;
int a[6], b[6] = {1, 1, 2, 2, 2, 8}, c[6];
int main(){
    for(int i = 0; i < 6; ++i){
        cin >> a[i];
        c[i] = b[i] - a[i];
    }
    for(int i = 0; i < 6; ++i) cout << c[i] << " ";
    return 0;
}