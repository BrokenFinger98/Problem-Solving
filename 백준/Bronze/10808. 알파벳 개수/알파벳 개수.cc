#include<bits/stdc++.h>
using namespace std;
int cnt[26];
int main(){
    string s;
    cin >> s;
    for(char a : s) cnt[a-'a']++;
    for(int i = 0; i < 26; ++i) cout << cnt[i] << " ";
}