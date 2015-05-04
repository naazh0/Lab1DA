#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;
//738,66 segundos desordenado
//206,8 segundos mayorMenor
//0.005455  segundos menorMayor
void bubbleSort(int arr[], int n){
	bool swapped = true;
	int j = 0;
	int tmp;
	while (swapped){
		swapped = false;
		j++;
		for (int i = 0; i < n - j; i++){
			if (arr[i] > arr[i + 1]){
				tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
				swapped = true;
			}
		}
	}
}

void runBubble(int array[], int n, const char nombre[]){
	float startTime, endTime;
	startTime = ((float)clock())/CLOCKS_PER_SEC;
	bubbleSort(array, n);
	endTime = ((float)clock())/CLOCKS_PER_SEC;
	float timeDiff = endTime-startTime;
	cout << "The bubble-sort algorithm took approximately " << timeDiff << " seconds to execute." << endl;
	ofstream myfile2 (nombre);
	for(int i = 0; i < 1000000 ; i++){
		if (myfile2.is_open()){
   			myfile2 << array[i] << '\n';
    	}
	}
	myfile2.close();
}