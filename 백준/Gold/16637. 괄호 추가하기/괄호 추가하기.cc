#include<bits/stdc++.h>
using namespace std; 
int n, ret = INT_MIN;
string s;
vector<int> num;
vector<char> oper;
int cal(int a, int b, char c){
    if(c == '+') return a+b;
    if(c == '-') return a-b;
    if(c == '*') return a*b;
}
void go(int here, int sum){
    if(here == num.size()-1){
        ret = max(ret, sum);
        return;
    }
    go(here + 1, cal(sum, num[here+1], oper[here]));
    if(here + 2 <= num.size()-1){
        int tmp = cal(num[here+1], num[here+2], oper[here+1]);
        go(here + 2, cal(sum, tmp, oper[here]));
    }
    return;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL);   
    cin >> n;
    cin >> s; 
    for(int i = 0; i < n; i++){
        if(i % 2 == 0) num.push_back(s[i] - '0');
        else oper.push_back(s[i]);
    }
    go(0, num[0]);
    cout << ret << "\n";
    return 0;
}