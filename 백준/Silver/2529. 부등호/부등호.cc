#include <bits/stdc++.h>
using namespace std;
int k;
char c;
vector<char> oper;
vector<int> num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
string trans(){
    string ret = "";
    for(int i = 0; i < k+1; ++i){
        ret += '0' + num[i];
    }
    return ret;
}
int check(){
    for(int i = 0; i < k; ++i){
        if(oper[i] == '<'){
            if(num[i] < num[i+1]) continue;
            else return 0;
        }else{
            if(num[i] > num[i+1]) continue;
            else return 0;
        }
    }
    return 1;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    string max_s = "", min_s = "";
    cin >> k;
    for(int i = 0; i < k; ++i){
        cin >> c;
        oper.push_back(c);
    }
    for(int i = 0; i < k; ++i){
        max_s += '0';
        min_s += '9';
    }
    do{
        if(check()){
            string ret = trans();
            if(ret > max_s) max_s = ret;
            if(ret < min_s) min_s = ret;
        }
    } while (next_permutation(num.begin(), num.end()));
    cout << max_s << "\n";
    cout << min_s << "\n";
    return 0;
}