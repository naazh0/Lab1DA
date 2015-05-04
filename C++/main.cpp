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
	ifstream myfile("menorMayor.in");
	if (myfile.is_open()){
		while ( getline (myfile,line) ){
			arr[i] = atoi(line.c_str());
			i++;
		}
	copiarArray(arr, original, 1000000);
	runBubble(arr, 1000000, "bubble_sort_menorMayor.out");
	copiarArray(original, arr, 1000000);
	runMerge(arr, 1, 1000000, "merge_sort_menorMayor.out");
	copiarArray(original, arr, 1000000);
	runQuick(arr, 1, 1000000, "quick_sort_menorMayor.out");
	copiarArray(original, arr, 1000000);
	runBucket(arr, 1000000, "bucket_sort_menorMayor.out");
	copiarArray(original, arr, 1000000);
	runRadix(arr, 1000000, "radix_sort_menorMayor.out");
	}
	myfile.close();

	ifstream myfile2("mayorMenor.in");
	if (myfile2.is_open()){
		while ( getline (myfile2,line) ){
			arr[i] = atoi(line.c_str());
			i++;
		}
	copiarArray(original, arr, 1000000);
	runBubble(arr, 1000000, "bubble_sort_mayorMenor.out");
	copiarArray(original, arr, 1000000);
	runMerge(arr, 1, 1000000, "merge_sort_mayorMenor.out");
	copiarArray(original, arr, 1000000);
	runQuick(arr, 1, 1000000, "quick_sort_mayorMenor.out");
	copiarArray(original, arr, 1000000);
	runBucket(arr, 1000000, "bucket_sort_mayorMenor.out");
	copiarArray(original, arr, 1000000);
	runRadix(arr, 1000000, "radix_sort_mayorMenor.out");
	}
	myfile2.close();
	ifstream myfile3("desordenado.in");
	if (myfile3.is_open()){
		while ( getline (myfile3,line) ){
			arr[i] = atoi(line.c_str());
			i++;
		}
	copiarArray(original, arr, 1000000);
	runBubble(arr, 1000000, "bubble_sort_desordenado.out");
	copiarArray(original, arr, 1000000);
	runMerge(arr, 0, 999999, "merge_sort_desordenado.out");
	copiarArray(original, arr, 1000000);
	runQuick(arr, 0, 999999, "quick_sort_desordenado.out");
	copiarArray(original, arr, 1000000);
	runBucket(arr, 1000000, "bucket_sort_desordenado.out");
	copiarArray(original, arr, 1000000);
	runRadix(arr, 1000000, "radix_sort_desordenado.out");
	}
	myfile3.close();
}