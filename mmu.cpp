#include "ram.cpp"
#include "rom.cpp"
#include <iostream>
using namespace std;

class mmu {

int main(){

    ram r1(50);
    rom r2(1000);

    //testng the methods
    r1.write(0, 25);
    r1.write(1, 24);
    r1.write(2, 9);
    r1.write(3, 7);

// array should be: {25,24,9,7}
    
    return 0;
   
}



};