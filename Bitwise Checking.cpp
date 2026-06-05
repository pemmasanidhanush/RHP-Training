// Online C++ compiler to run C++ program online
#include <iostream>
using namespace std;

int main() {
    char str[1000001];
    cin >> str;

    int smallFlag = 0;
    int capFlag = 0;

    for (int i = 0; str[i] != '\0'; i++) {
        char ch = str[i];

        if (ch >= 'a' && ch <= 'z') {
            smallFlag |= (1 << (ch - 'a'));
        }
        else if (ch >= 'A' && ch <= 'Z') {
            capFlag |= (1 << (ch - 'A'));
        }
    }

    if (smallFlag == (1 << 26) - 1)
        cout << "YES, All lowercase letters are present\n";
    else
        cout << "Not all lowercase letters are present\n";

    if (capFlag == (1 << 26) - 1)
        cout << "YES, All uppercase letters are present\n";
    else
        cout << "Not all uppercase letters are present\n";

    return 0;
}