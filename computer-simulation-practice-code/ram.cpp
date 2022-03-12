#include <iostream>
#include <string>
using namespace std;

class ram {

private:
    int* capacity;

public:
    ram(int size) {
        capacity = new int[size];
}
    
void write(int a, int b) {
    capacity[a] = b;
}

void read(int a){
    cout << "I am ram          ";
    cout << capacity[a];
}

void initialize(int adress, string a){
//starting from int adress, fill the array with each character from a

    for(int i = 0; i < a.length(); i++){
        char myChar = a[i];
        int a = int(myChar);
        capacity[adress] = myChar;
        adress++;
        }
}

};



