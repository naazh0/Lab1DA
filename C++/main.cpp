#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
#include "bubblesort.h"
#include "mergesort.h"
#include "quicksort.h"
#include "radixsort.h"
#include "bucketsort.h"

using namespace std;

void copiarArray(int origin[], int destination[], int len){
	for(int i = 0; i < len ; i++){
		destination[i] = origin[i];
	}
}

int main(){
	string line;
	int i = 0;
	int arr[1000000], original[1000000];
	ifstream myfile ("menorMayor.in");
	if (myfile.is_open()){
		while ( getline (myfile,line) ){
			arr[i] = atoi(line.c_str());
			i++;
		}
	copiarArray(arr, original, 1000000);
	runBucket(arr, 1000000, "bucket_sort_menorMayor.out");
	}
}