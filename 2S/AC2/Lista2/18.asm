.text
.globl main
main:
# x - s0   y - s1
addi $t0, $0, 0x1001   # t0 = primeira posicao da memoria
sll $t0, $t0, 16
lw $s0, 0($t0)         # pegar valores da memoria
lw $s1, 4($t0)
addi $s1, $s1, -1	# diminuir 1 execucao
add $s2, $0, $s0       # s2 = x
do:
mult $s2, $s0          # multiplicar valor atual por x
mflo $s2               # pegar resultado da multiplicacao em lo
addi $s1, $s1, -1      # reduzir s1
bne $s1, $0, do		# se s1 != 0, ir para do
sw $s2, 8($t0)


.data
x: .word 15
y: .word 7
