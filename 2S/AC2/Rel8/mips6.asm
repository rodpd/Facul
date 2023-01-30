# x - s0
# y - s1
# z - s2
addi $t0, $zero, 0x7fff # t0 = 0x7fff
sll  $t0, $t0, 16	# t0 = 0x7fff
ori  $s0, $t0, 0xffff   # x = 0x7fffffff = maior n
addi $t0, $zero, 0x493e # t0 = 0x493e
sll  $s1, $t0, 4	# y = 0x493e0 = 300000
sll  $t0, $s1, 2	# t0 = 4y
sub  $s2, $s0, $t0	# z = x-t0 = x-4y
