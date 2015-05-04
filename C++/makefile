# Makefile del proyecto
CC			= g++
CFLAGS		= -g -Wall


all: main

main: bubblesort.o mergesort.o quicksort.o radixsort.o bucketsort.o main.o
	$(CC) $(CFLAGS) -o $@ $^

bubblesort.o: bubblesort.h
mergesort.o: mergesort.h
quicksort.o: quicksort.h
radixsort.o: radixsort.h
bucketsort.o: bucketsort.h

clean:
	rm -f *o main

