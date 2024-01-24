#include<bits/stdc++.h>
using namespace std;
string s, tmp;
int main(){
    cin >> s;
    tmp = s;
    reverse(s.begin(), s.end());
    if(s.compare(tmp)) cout << 0;
    else cout << 1;
}
