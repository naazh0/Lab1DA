#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;
//0.271556 seconds desordenado
//0.080978 seconds mayorMenor
//0,076505 seconds menorMayor
void quickSort(int arr[], int left, int right){
	int i = left, j = right;
	int tmp;
	int pivot = arr[(left + right) / 2];
	while (i <= j){
		while (arr[i] < pivot)
			i++;
		while (arr[j] > pivot)
			j--;
		if (i <= j){
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
	}
	if (left < j)
		quickSort(arr, left, j);
	if (i < right)
		quickSort(arr, i, right);
}

void runQuick(int array[], int left, int right, const char nombre[]){
	float startTime, endTime;
	startTime = ((float)clock())/CLOCKS_PER_SEC;
	quickSort(array, left, right);
	endTime = ((float)clock())/CLOCKS_PER_SEC;
	float timeDiff = endTime-startTime;
	cout << "The quick-sort algorithm took approximately " << timeDiff << " seconds to execute." << endl;
	ofstream myfile2 (nombre);
	for(int i = 0; i < 1000000 ; i++){
		if (myfile2.is_open()){
   			myfile2 << array[i] << '\n';
    	}
	}
	myfile2.close();
}

