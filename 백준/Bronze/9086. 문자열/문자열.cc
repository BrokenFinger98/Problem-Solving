#include<bits/stdc++.h>
using namespace std;
int n;
string s;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; ++i){
        cin >> s;
        cout << s[0] << s[s.length()-1] << "\n";
    }
    return 0;
}