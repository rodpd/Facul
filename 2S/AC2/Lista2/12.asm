.text
.globl main
main:
# fibonacci1 - $s0
# fibonacci2 - $s1
# i - $s2
# j - $s3
addi $s0, $0, 1   # inicializar fib0
addi $s1, $0, 1   # inicializar fib1
addi $s2, $0, 0   # j = i
addi $s3, $0, 98  # j = 98
addi $t0, $0, 0x1001  # guardar primeira posicao da memoria em t0
sll $t0, $t0, 16
sw $s0, 0($t0)    # guardar primeiro valor de fibonacci
addi $t0, $t0, 4  # ir para a proxima posicao da memoria
sw $s1, 0($t0)    # guardar segundo valor de fibonacci
fibonacci:
addi $t0, $t0, 4   # t0 = proxima posicao memoria
add $t1, $s0, $s1  # t1 = fib0 + fib1
sw  $t1, 0($t0)    # guardar valor de fibonacci na memoria
add $s0, $0, $s1   # s0 = s1
add $s1, $0, $t1   # s1 = t1 = ultimo valor de fibonacci calculado
addi $s2, $s2, 1   # i = i+1
bne $s2, $s3, fibonacci # voltar para fibonacci se i != j





.data