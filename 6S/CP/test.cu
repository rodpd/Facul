/*
    TAMANHO = 500

    SEQUENCIAL:
    3.690s

    PARALELO MULTICORE:
    0.538s

    PARALELO GPU OPENMP:
    0.311s
    warps_launched = 2592
    warp_execution_efficiency = 21.73%

    PARALELO GPU CUDA:
    0.205s
    resultado do nvprof no parcode:
    ==2574== NVPROF is profiling process 2574, command: ./mmGPU
    ==2574== Profiling application: ./mmGPU
    ==2574== Profiling result:
    No events/metrics were profiled.
*/


#include <stdio.h>
#include <stdlib.h>


__global__ void mm_cuda(double* a, double* b, double* c, int width) 
{
  int i = blockIdx.x*blockDim.x+threadIdx.x;
  int j = blockIdx.y*blockDim.y+threadIdx.y;
    if ( i < width && j < width ) {
    double sum = 0;
    for ( int k = 0; k < width; k++ ) {
      double x = a[i*width+k];
      double y = b[k*width+j];
      sum += x*y;
    }
    c[i*width+j] = sum;
  }
}
 

void mm(double* a, double* b, double* c, int width) 
{
    int n = width*width;
    #pragma omp target map(tofrom: a[:n], b[:n], c[:n])
    #pragma omp teams distribute parallel for simd
    // #pragma omp parallel for schedule(static)
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

    for(int i = 0; i < width; i++) {
        for(int j = 0; j < width; j++) {
            a[i*width+j] = i;
            b[i*width+j] = j;
            c[i*width+j] = 0;
        }
    }

  // mm(a,b,c,width);
 
  int tamanho = n*(sizeof(double));
  double *d_a, *d_b, *d_c;


  cudaMalloc( &d_a, tamanho);
  cudaMemcpy(d_a, a, tamanho, cudaMemcpyHostToDevice);

  cudaMalloc( &d_b, tamanho);
  cudaMemcpy(d_b, b, tamanho, cudaMemcpyHostToDevice);

  cudaMalloc( &d_c, tamanho);

  int block_size = 2048;
  dim3 dimGrid((int)ceil(sqrt(n/block_size)),(int)ceil(sqrt(n/block_size)), 1);
  dim3 dimBlock((int)ceil(sqrt(block_size)),(int)ceil(sqrt(block_size)), 1);
  mm_cuda<<<dimGrid,dimBlock>>>(d_a, d_b, d_c, width);

  cudaMemcpy(c, d_c, tamanho, cudaMemcpyDeviceToHost);
 
/*
    for(int i = 0; i < width; i++) {
    for(int j = 0; j < width; j++) {
      printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
    }
   }
*/


  cudaFree(d_a);
  cudaFree(d_b);
  cudaFree(d_c);

}
