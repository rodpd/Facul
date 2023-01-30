.text
.globl main
main:
addi $t0, $0, 0x1001 # pegar numeros na memoria
sll $t0, $t0, 16
lw $s0, 0($t0)
lw $s1, 4($t0)
lw $s2, 8($t0)
slt $t0, $s0, $s1  # comparar primeiro numero com segundo. Se menor, t0=1. Senao, t0=0
bne $t0, $0, ultimos  # se primeiro for maior, trocar. Senao, passar para o proximo passo
add $s1, $0, $s0   # passar s0 para s1
ultimos:
slt $t0, $s1, $s2 # comparar segundo e terceiro numeros. Se s1 < s2, t0=1. Senao, t0=0
bne $t0, $0, fim  # se segundo for maior, fazer s2=s3
add $s1, $0, $s2
fim:
addi $s4, $0, 16

.data
A: .word 23
B: .word 98
C: .word 17