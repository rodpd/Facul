#include <stdio.h>
#include <stdlib.h>

__global__ void vecadd_cuda(double* a, double* b, double* c, int width) {
  int i = blockIdx.x*blockDim.x+threadIdx.x;

  if (i < width)
    c[i] = a[i] + b[i];
}

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
  int width = 10000000;
  double *a = (double*) malloc (width * sizeof(double));
  double *b = (double*) malloc (width * sizeof(double));
  double *c = (double*) malloc (width * sizeof(double));

  for(int i = 0; i < width; i++) {
    a[i] = i;
    b[i] = width-i;
    c[i] = 0;
  }

  int size = width*sizeof(double);
  double *d_a, *d_b, *d_c;

  cudaMalloc((void **) &d_a, size);
  cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);

  cudaMalloc((void **) &d_b, size);
  cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);

  cudaMalloc((void **) &d_c, size);

  int block_size = 1024;
  dim3 dimGrid((width-1)/block_size + 1, 1, 1);
  dim3 dimBlock(block_size,1,1);

  vecadd_cuda<<<dimGrid,dimBlock>>>(d_a, d_b, d_c, width);

  cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);

  for(int i = 0; i < width; i++)
    printf("\n c[%d] = %f",i,c[i]);

  cudaFree(d_a);
  cudaFree(d_b);
  cudaFree(d_c);

}