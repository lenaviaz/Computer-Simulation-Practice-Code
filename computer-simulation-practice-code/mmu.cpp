#include <iostream>
#include <string>
#include "ram.cpp"
#include "rom.cpp"
using namespace std;

class mmu {

private:
    int* capacity;
    int size = 10000;

public:
    mmu() {
      capacity = new int[size]; 
}

void attach(ram r1, int adress){
}
};

int main(){

    mmu m1;    
    ram b1(45);
    rom r2(20);

   // m1.attach(b1, 5);

   // b1.write(0,78);
   // b1.write(1, 5);
   // b1.write(2, 38);
   // b1.write(3, 55);
   // b1.write(4, 57);

    b1.initialize(5, "hello");
    r2.initialize(3, "hahaha!!!!!");

    //r2.write(3, 125);
    //should do nothing

    b1.read(5); // 104
    b1.read(6); // 101
    b1.read(7); // 108
    b1.read(8); // 108
    b1.read(9); // 111



   //r2.read(3);
    return 0;

}