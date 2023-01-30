.text
.globl main
main:
# x3 = x1 + x2
# x1 - $s1
# x2 - $s2
# x3 - $s3
# x4 - $s4
# soma - $s5
addi $t0, $zero, 0x1001	
sll $t0, $t0, 16	
lw $s1, 0($t0)		# armazenar x1 em $s1
lw $s2, 4($t0)		# armazenar x2 em $s2
add $t1, $s1, $s2	# t1 = x1+x2
lw $s3, 8($t0) 		# armazenar x3 em $s3
add $t1, $t1, $s3	# t1 = x1+x2+x3
lw $s4, 12($t0)		# armazenar x4 em $s4
add $t1, $t1, $s4	# t1 = x4+x3+x2+x1
sw $t1, 16($t0)		# guardar soma




.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
soma: .word -1
