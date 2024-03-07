#include<bits/stdc++.h>
using namespace std;
int N;
string s, tmp;
vector<string> ret;
void go(){
    while (1){
        if(tmp.size() && tmp.front() == '0') tmp.erase(tmp.begin());
        else break;
    }
    if(tmp.size() == 0)
        tmp = "0";
    ret.push_back(tmp);
    tmp = "";
}
bool cmp(string a, string b){
    if(a.length() == b.length())
        return a < b;
    return a.length() < b.length();
}
int main(){
    cin >> N;
    while (N--){
        cin >> s;
        tmp = "";
        for(int i = 0; i < s.size(); ++i){
            if(s[i] >= '0' && s[i] <= '9') tmp += s[i];
            else if(tmp.size()) go();
        }
        if(tmp.size()) go();
    }
    sort(ret.begin(), ret.end(), cmp);
    for(auto it : ret) cout << it << "\n";
}