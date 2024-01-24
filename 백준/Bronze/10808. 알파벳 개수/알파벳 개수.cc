#include<bits/stdc++.h>
using namespace std;
int a[26];
int main(){
    string s;
    cin >> s;
    for(auto it : s) ++a[it - 'a'];
    for(auto it : a) cout << it << " ";
    return 0;
}