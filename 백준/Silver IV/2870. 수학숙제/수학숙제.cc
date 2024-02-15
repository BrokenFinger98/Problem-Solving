#include<bits/stdc++.h>
using namespace std;
vector<string> v;
int N;
string s, ret;
void go(){
    while (1){
        if(ret.size() && ret.front() == '0') ret.erase(ret.begin());
        else break;
    }
    if(ret.size() == 0) ret = "0";
    v.push_back(ret);
    ret = "";
}
bool cmp(string a, string b){
    if(a.length() == b.length())
        return a < b;
    return a.length() < b.length();
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> N;
    for(int i = 0; i < N; ++i){
        cin >> s;
        ret = "";
        for(int j = 0; j < s.size(); ++j){
            if(s[j] < 65) ret += s[j];
            else if(ret.size()) go();
        }
        if(ret.size()) go();
    }
    sort(v.begin(), v.end(), cmp);
    for(auto it : v) cout << it << "\n";
    return 0;
}