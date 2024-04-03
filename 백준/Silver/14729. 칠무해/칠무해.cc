#include<bits/stdc++.h>
using namespace std;
double n, a;
priority_queue<double, vector<double>, greater<double>> pq;
int main(){
    cin >> n;
    for(int i = 0; i < n; ++i){
        cin >> a;
        pq.push(a);
    }
    for(int i = 0; i < 7; ++i){
        printf("%.3f\n", pq.top());
        pq.pop();
    }
    return 0;
}