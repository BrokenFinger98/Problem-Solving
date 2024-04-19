#include<bits/stdc++.h>
using namespace std;
string s1, s2;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> s1 >> s2;
    reverse(s1.begin(), s1.end());
    reverse(s2.begin(), s2.end());
    int a = atoi(s1.c_str());
    int b = atoi(s2.c_str());
    cout << max(a, b) << "\n";
    return 0;
}