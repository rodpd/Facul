.text
.globl main
main:
# y = x - z + 300000
# x - $s0
# z - $s1
# y - $s2
addi $t0, $0, 0x1001
sll $t0, $t0, 16
lw $s0, 0($t0)
lw $s1, 4($t0)
addi $s2, $0, 0x7fff
.data
x: .word 100000
z: .word 200000
y: .word 0 # esse valor deverá ser sobrescrito após a execução do programa.
