#include<bits/stdc++.h>
using namespace std;
int n;
string s = "";
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    for(int i = 0; i < n/4; ++i){
        s += "long ";
    }
    s += "int";
    cout << s << "\n";
    return 0;
}