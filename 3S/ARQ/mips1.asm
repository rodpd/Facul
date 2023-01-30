.text
.globl main
main:
# x3 = x1 + x2
# x1 - $s1
# x2 - $s2
# x3 - $s3
addi $t0, $zero, 0x1001	
sll $t0, $t0, 16	
lw $s1, 0($t0)		
lw $s2, 4($t0)		
inicio:
add $s3, $s1, $s2	# x3 = x1 + x2
sw $s3, 8($t0) 		
lw $s4, 12($t0)
add $s4, $s4, $s3
sw $s4, 12($t0)
j inicio




.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
