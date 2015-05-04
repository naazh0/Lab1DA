#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;
//0,558663 seconds desordenado
//0,412632 seconds mayorMenor
//0,411407 seconds menorMayor
void merge(int a[], const int low, const int mid, const int high){
	int * b = new int[high+1-low];
	int h,i,j,k;
	h=low;
	i=0;
	j=mid+1;
	while((h<=mid)&&(j<=high)){
		if(a[h]<=a[j]){
			b[i]=a[h];
			h++;
		}
		else{
			b[i]=a[j];
			j++;
		}
		i++;
	}
	if(h>mid){
		for(k=j;k<=high;k++){
			b[i]=a[k];
			i++;
		}
	}
	else{
		for(k=h;k<=mid;k++){
			b[i]=a[k];
			i++;
		}
	}
	for(k=0;k<=high-low;k++){
		a[k+low]=b[k];
	}
	delete[] b;
}

void merge_sort( int a[], const int low, const int high ){
	int mid;
	if( low < high ){
		mid = ( low + high ) / 2;
		merge_sort( a, low, mid );
		merge_sort( a, mid + 1, high );
		merge( a, low, mid, high );
	}
}

void runMerge(int array[], int low, int high, const char nombre[]){
	float startTime, endTime;
	startTime = ((float)clock())/CLOCKS_PER_SEC;
	merge_sort(array, low, high);
	endTime = ((float)clock())/CLOCKS_PER_SEC;
	float timeDiff = endTime-startTime;
	cout << "The merge-sort algorithm took approximately " << timeDiff << " seconds to execute." << endl;
	ofstream myfile2 (nombre);
	for(int i = 0; i < 1000000 ; i++){
		if (myfile2.is_open()){
   			myfile2 << array[i] << '\n';
    	}
	}
	myfile2.close();
}