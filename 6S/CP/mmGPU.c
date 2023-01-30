/*
    TAMANHO = 500

    SEQUENCIAL:
    3.690s

    PARALELO MULTICORE:
    0.538s

    PARALELO GPU (distribute):
    1.810s
    MAIN - warps_launched = 72
    MM - warps_launched = 55096
    MAIN - warp_execution_efficiency = 100%
    MM - warp_execution_efficiency = 100%

    PARALELO GPU (distribute parallel for):
    0.421s
    MAIN - warps_launched = 72
    MM - warps_launched = 2568
    MAIN - warp_execution_efficiency = 33.11%
    MM - warp_execution_efficiency = 21.73%   
    
    PARALELO GPU (distribute parallel for simd):
    0.311s
    MAIN - warps_launched = 72
    MM - warps_launched = 2592
    MAIN - warp_execution_efficiency = 33.11%
    MM - warp_execution_efficiency = 21.73%

*/


#include <stdio.h>
#include <stdlib.h>

void mm(double* a, double* b, double* c, int width) 
{
    int n = width*width;
    #pragma omp target map(tofrom: a[:n], b[:n], c[:n])
    #pragma omp teams distribute parallel for simd
    // #pragma omp parallel for private (i, j, k) schedule(static)
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < width; j++) {
        double sum = 0;
        for (int k = 0; k < width; k++) {
          double x = a[i * width + k];
          double y = b[k * width + j];
          sum += x * y;
        }
        c[i * width + j] = sum;
      }
    }
}
 
int main()
{
  int width = 500;
  int n = width*width;
  double *a = (double*) malloc (width * width * sizeof(double));
  double *b = (double*) malloc (width * width * sizeof(double));
  double *c = (double*) malloc (width * width * sizeof(double));

    #pragma omp target map(tofrom: a[:n], b[:n], c[:n])
    #pragma omp teams distribute parallel for simd
    // #pragma omp parallel for private (i, j, k) schedule(static)
    for(int i = 0; i < width; i++) {
        for(int j = 0; j < width; j++) {
            a[i*width+j] = i;
            b[i*width+j] = j;
            c[i*width+j] = 0;
        }
    }
 
  mm(a,b,c,width);
 
  //  for(int i = 0; i < width; i++) {
  //  for(int j = 0; j < width; j++) {
  //    printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
  //  }
  // }
}