#include<bits/stdc++.h>
using namespace std;
int N, M, J, K, s, e, cnt;
int main(){
	cin >> N >> M >> J;
	s = 1;
	e = s + M -1;
	for(int i = 0; i < J; ++i){
		cin >> K;
		if(K > e){
			for(int j = e; j < K; ++j){
				++e; ++s;
				++cnt;
			}
		}else if(K < s){
			for(int j = s; j > K; --j){
				--e; --s;
				++cnt;
			}	
		}
	}
	cout << cnt << "\n";
}