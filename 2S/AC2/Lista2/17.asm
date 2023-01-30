.text
.globl main
main:
# s0 - endereco base ( arg1 )     s1 - num x     s2 - posicao i     
# s3 - qnt de elementos ( arg2 )     s4 - valor final soma
addi $s0, $0, 0x1001    #endereco base
sll $s0, $s0, 16
add $a0, $0, $s0     # arg0(posicao na memoria) = 0x10010000
addi $s3, $0, 100
add $a1, $0, $s3    # arg1(tamanho) = 100
jal funcao         # chamada da funcao
add $s4, $0, $v0   # mudar s4 p/ valor retornado ( soma )


j fim
funcao:
addi $s2, $0, 0    # posicao inicial = 0
do:
andi $t0, $s2, 1   # t0 = 0 se for par, t0 = 1 se for impar
bne $t0, $0, impar # se for par, continuar. Senao, ir para impar
sll $s1, $s2, 1    # s1 = 2i
addi $s1, $s1, -1  # s1 = 2i-1
j guardar
impar:
add $s1, $0, $s2   # s1 = i
guardar:
sw $s1, 0($a0)      # guardar numero na memoria
add $v0, $v0, $s1   # somar num atual ao total
addi $a0, $a0, 4    # ir p/ proxima posicao
addi $a1, $a1, -1   # tamanho = tamanho-1
addi $s2, $s2, 1    # i = i+1   ( prox posicao )
bne $a1, $0, do     # continuar loop enquanto tamanho != 0
jr $ra
fim:
.data

