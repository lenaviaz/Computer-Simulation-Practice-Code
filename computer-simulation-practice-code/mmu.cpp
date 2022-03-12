#include <iostream>
#include <string>
#include "ram.cpp"
#include "rom.cpp"
using namespace std;


rom r1(5000);
ram r2(5000);
int rom_end;

class mmu {

private:
    int* capacity;
    int size = 10000;

public:
    mmu() {
    capacity = new int[size]; 
}


void initialize(int adress, string a){
if(adress<rom_end) {
    r1.initialize(adress, a);
}
if(adress>=rom_end){
    r2.initialize(adress, a);
}


}

void attach(rom r1, int adress){
    rom_end = r1.getSize();
   // int greatThan = r2.getSize();
    cout << rom_end;
   
}


void attach(ram r2, int adress){
  
}


void write(int a, int b) {

 if(a >= 5000){
    r2.write(a, b);
 }

}

void read(int a){

if(a<rom_end) {
    r1.read(a);
}
if(a>=rom_end){
    r2.read(a);
}
}

};

int main(){

    rom r1(5000);
    ram r2(5000);
    mmu m1;    


    m1.attach(r1, 5000);
    m1.attach(r2, 5000);

    m1.initialize(10, "hello");
    m1.initialize(5000, "!123");

    m1.write(10, 28);
    
    m1.write(5000, 28);
   // m1.read(10);
     m1.read(5000);
     m1.read(10);



    return 0;

}