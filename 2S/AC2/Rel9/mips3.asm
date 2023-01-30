.text
.globl main
main:
# y = x - z + 300000
# x - $s0
# z - $s1
# y - $s2
addi $t0, $0, 0x1001
sll $t0, $t0, 16	# t0 = 0x10010000
lw $s0, 0($t0)		# armazenar x em $s0
lw $s1, 4($t0)		# armazenar z em $s1
addi $t2, $0, 0x493e	# $t2 = 0x493e
sll $t2, $t2, 4		# $t2 = 0x493e0 = 300000
sub $t1, $s0, $s1	# t1 = x-z
add $s2, $t1, $t2	# y = x-z+300000
sw  $s2, 8($t0)		# guardar resultado em y

.data
x: .word 100000
z: .word 200000
y: .word 0 # esse valor deverá ser sobrescrito após a execução do programa.
