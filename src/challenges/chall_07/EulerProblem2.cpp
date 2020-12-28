#include <iostream>
#include <vector>
int fib(int x);
int main(){
	std::vector<int> list;
	std::cout << "The sequence of Fibonacci numbers:" << std::endl ;
	for(int i = 0; fib(i) <= 4000000; i++){
		if(fib(i) % 2 == 0)
		      	list.push_back(fib(i));
		std::cout <<fib(i) << std::endl;
	}
	int sum = 0;
	for(int x : list){
		sum += x;
	}
	std::cout << std::endl << "The sum of even numbers is:" << sum;
	return 0;
}
int fib(int x){
	if(x == 0 || x == 1) return x;
	else return fib(x-1) + fib(x-2);
}
