.text
.globl main
main:
# k - $s0
addi $t0, $zero, 0x1001
sll  $t0, $t0, 16
addi  $t0, $t0, 0x000c	# posicao inicial - 0x1001000c
lw   $t0, 0($t0)	# carregar ponteiro 1 - 0x10010008
lw   $t0, 0($t0)	# carregar ponteiro 2 - 0x10010004
lw   $t0, 0($t0)	# carregar ponteiro 3 - 0x10010000
lw   $s0, 0($t0)	# carregar valor -> s0 = x
add  $s0, $s0, $s0	# k = 2k
sw   $s0, 0($t0)	# armazenar 2k em endereco de x

.data
x: .word 50	# considerando x como 50
p1: .word 0x10010000
p2: .word 0x10010004
p3: .word 0x10010008
