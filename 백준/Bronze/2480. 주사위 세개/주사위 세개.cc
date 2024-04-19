#include<bits/stdc++.h>
using namespace std;
int a, b, c;
int main(){
    cin >> a >> b >> c;
    if(a == b && b == c){
        cout << 10000+a*1000 << "\n";
    }else if(a == b && a != c){
        cout << 1000 + a*100 << "\n";
    }else if(a == c && a != b){
        cout << 1000 + a*100 << "\n";
    }else if(b == c && a != b){
        cout << 1000 + b*100 << "\n";
    }else if(a != c && a != b && b != c){
        cout << max(max(a, c), b)*100 << "\n";
    }
    return 0;
}