#include <iostream>
#include <string>
using namespace std;

class ram {

private:
    int* capacity;
    int size;

public:
    ram(int s) {
        size = s;
        capacity = new int[size];
      
}

int getSize(){
    return size;
}
    
void write(int a, int b) {
    capacity[a] = b;
}

int read(int a){
    cout << "I am ram          ";
    cout << capacity[a];
    return capacity[a];
}


void initialize(int adress, string a){
//starting from int adress, fill the array with each ASCII val of coorep character from a

    for(int i = 0; i < a.length(); i++){
        char myChar = a[i];
        int a = int(myChar);
        capacity[adress] = myChar;
        adress++;
        }
}

};



