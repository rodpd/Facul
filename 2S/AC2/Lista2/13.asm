.text
.globl main
main:
# x(valor lido) - $s0
# flag - $s1
addi $t0, $0, 0x1001
sll $t0, $t0, 16
lw $s0, 0($t0)
sle $t0, $s0, 100
sge $t1, $s0, 50
sle $t2, $s0, 200
sge $t3, $s0, 150
and $t0, $t0, $t1
and $t1, $t2, $t3
or $s1, $t0, $t1

.data
x : .word 50
