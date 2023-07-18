#include<bits/stdc++.h>
using namespace std;
int main(){
    string s, tmp, s1, s2;
    int a;
    int n;
    cin >> n;
    getchar();
    getline(cin, s);
    a = s.find('*');
    s1 = s.substr(0, a);
    s2 = s.substr(a+1);
    for(int i = 0; i < n; ++i){
        getline(cin, tmp);
        if(s1.size() + s2.size() > tmp.size()){
            cout << "NE" <<'\n';
        }
        else{
            if(s1 == tmp.substr(0, s1.size()) && s2 == tmp.substr(tmp.size() - s2.size())) cout << "DA" << '\n';
            else cout << "NE" << '\n';
        }
    }
}