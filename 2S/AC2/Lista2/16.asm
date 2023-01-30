.text
.globl main
main:
addi $s0, $0, 0
# guardar os 100 numeros na memoria
# t0 - endereco base    t1 - endereco atual
# s0 - numero    s1 - j ( p/ terminar loop )
addi $s1, $0, 100
addi $t0, $0, 0x1001
sll $t0, $t0, 16
addi $t1, $t0, -4
do:
addi $t1, $t1, 4
addi $s0, $s0, 1
sw $s0, 0($t1)
addi $s1, $s1, -1
bne $s1, 0, do

# exercicio 15 - adaptar na hr d passar p/ caderno ( endereco base no enunciado ta em s1, aqui em t0 )
# s2 - soma
# tacar 2 nops dps de do2 p/ segunda parte
addi $s1, $0, 100
addi $t0, $0, 0x1001
sll $t0, $t0, 16
addi $t1, $t0, -4
addi $s2, $0, 0
do2:
addi $t1, $t1, 4
addi $s0, $s0, 1
lw $s0, 0($t1)
add $s2, $s2, $s0
addi $s1, $s1, -1
bne $s1, 0, do2
sw $s2, 4($t1)

