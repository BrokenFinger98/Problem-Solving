#include<bits/stdc++.h>
using namespace std;
int n, ret = INT_MIN;
string s;
vector<char> oper_str;
vector<int> num;
int oper(char a, int b, int c){
    if(a == '+') return b + c;
    if(a == '-') return b - c;
    if(a == '*') return b * c;
}
void go(int here, int sum){
    if(here == num.size()-1){
        ret = max(ret, sum);
        return;
    }
    go(here+1, oper(oper_str[here], sum, num[here+1]));
    if(here + 2 <= num.size()-1){
        int tmp = oper(oper_str[here+1], num[here+1], num[here+2]);
        go(here+2, oper(oper_str[here], sum, tmp));
    }
    return;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    cin >> s;
    for(int i = 0; i < n; ++i){
        if(i%2 == 0) num.push_back(s[i] - '0');
        else oper_str.push_back(s[i]);
    }
    go(0, num[0]);
    cout << ret << "\n";
    return 0;
}