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


void initialize(int adress, string a){


}

void attach(ram r1, int adress){
  

}

void attach(rom r1, int adress){
   
}



void write(int a, int b) {


    capacity[a] = b;

}

void read(int a){

 //if ram -> ram.read()
 //if rom -> rom.read()

    cout << "I am mmu          ";
    cout << capacity[a];
}

};

int main(){

  
    mmu m1;    
    ram b1(5000);
    rom r2(5000);


    m1.attach(b1, 0);
    m1.attach(r2, 5000);

    m1.initialize(10, "hello");

    //m1.initialize(0, "hello");
    
   // m1.attach(b1, 5);

   // b1.write(0,78);
   // b1.write(1, 5);
   // b1.write(2, 38);
   // b1.write(3, 55);
   // b1.write(4, 57);

   // b1.initialize(5, "hello");
    //r2.initialize(3, "hahaha!!!!!");

    //r2.write(3, 125);
    //should do nothing

   // b1.read(5); // 104
  //  b1.read(6); // 101
   // b1.read(7); // 108
  //  b1.read(8); // 108
  //  b1.read(9); // 111



   //r2.read(3);
    return 0;

}