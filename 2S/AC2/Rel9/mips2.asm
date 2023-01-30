.text
.globl main
main:
# y = 127x - 65z + 1
# x - $s0
# z - $s1
# y - $s2
addi $t0, $0, 0x1001 	
sll $t0, $t0, 16 	# t0 = 0x10010000
lw $t1, 0($t0)   	# t1 = x
sll $t2, $t1, 7  	# t2 = 128x
sub $t2, $t2, $t1 	# t2 = 127x
lw $t3, 4($t0) 		# t3 = z
sll $t4, $t3, 6  	# t4 = 64z
add $t4, $t4, $t3 	# t4 = 65z
sub $t5, $t2, $t4 	# t5 = t2 - t4 = 127x - 65z
addi $t5, $t5, 1  	# t5 = t5 + 1 = 127x - 65z + 1
sw $t5, 8($t0) 		# guardar y

.data
x: .word 5
z: .word 7
y: .word 0 # esse valor deverá ser sobrescrito após a execução do programa.
