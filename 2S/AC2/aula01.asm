#x=1
#y=2
#z=x+y;
#x-s0	y-s1	z-s2
#inicio

.text

.globl main
main: ori, $s0, $zero, 100000 #x=1
ori, $s1, $zero, 2 #y=2
la: add, $s2, $s0, $s1 #z=x+y
aqui: sll $zero, $zero, 0 #nop