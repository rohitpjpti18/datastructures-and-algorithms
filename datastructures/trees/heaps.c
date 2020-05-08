#include<stdio.h>
#define SIZE 50

void swap(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
}


int delete_max(int heap[], int length){
    heap[0] = heap[length-1];
    int j = 0;
    while((2*j)+1 < length){
        if(heap[j] < heap[2*j+1] && heap[j] < heap[2*j + 2]){
            if(heap[2*j+1] >= heap[2*j+2]){
                swap(&heap[j], &heap[2*j+1]); 
                j=(2*j)+1;
            }
            else{ 
                swap(&heap[j], &heap[2*j + 2]) ; 
                j = (2*j)+2 ; 
            } 
        }else{
            break;
        } 
    }
    return --length;
}


int insert(int heap[], int length, int value){
    if(length == SIZE){
        printf("Heap SIZE limit exceeded!\n");
        return -1;
    }
    
    heap[length] = value;
    int j = length;
    length++;
    while(j > 0){
        // if parent is less than the child
        if(heap[(j-1)/2] < heap[j] ){
            swap(&heap[(j-1)/2], &heap[j]);
        }
        j = (j-1)/2;
    }
    
    return length;
}


void print_heap(int heap[], int length){
    for(int i = 0; i<length; i++){
        printf("%d ", heap[i]);
    }
    printf("\n");
}


int main(){
    int a;
    int heap[SIZE] = {33, 24, 7, 12, 5, 6, 5, 10, 11};
    int length = 9;

    print_heap(heap, length);
    length = insert(heap, length, 68);
    printf("%d %d\n", length, heap[length]);
    print_heap(heap, length);
    length = delete_max(heap, length);
    print_heap(heap, length);

    return 0;
}