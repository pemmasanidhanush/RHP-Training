#include <iostream>
#include<string>
using namespace std;

int main() {
    string s;
    cin>>s;
    int l=s.length();
    for(int ctr=1;ctr<(1<<l);ctr++){
        string combinations="";
        for(int sh=0;sh<l;sh++){
            if((ctr&(1<<sh))>0){
                combinations+=s[sh];
            }
        }
        cout<<combinations <<"\n";
    }
    return 0;
}
