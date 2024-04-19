#include<bits/stdc++.h>
using namespace std;
int h, m, cook;
int main(){
    cin >> h >> m;
    cin >> cook;
    cout << (h + (m+cook)/60)%24 << " " << (m+cook)%60 << "\n"; 
    return 0;
}