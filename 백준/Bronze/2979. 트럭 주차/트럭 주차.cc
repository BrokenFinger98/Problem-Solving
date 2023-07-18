#include<bits/stdc++.h>
using namespace std;
int a,b,c,x,y,z[100],sum;
int main(){
    cin >> a >> b >> c;
    for(int i = 0; i < 3; ++i){
        cin >> x >> y;
        for(int j = x; j < y; ++j) z[j]++;
    }
    for(int j = 1; j < 100; j++){
        if(z[j]){
            if(z[j] == 1) sum += a;
            else if(z[j] == 2) sum += b*2; 
            else if(z[j] == 3) sum += c*3;
        }
    }
    cout << sum <<'\n';
}