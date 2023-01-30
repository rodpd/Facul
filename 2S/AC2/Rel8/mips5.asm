# x - s0
# y - s1
# z - s2
addi $t0, $zero, 0x186a  # t0 = 0x186a
sll  $s0, $t0, 4 	 # x = 0x186a0 = 100000
addi $t0, $zero, 0x30d4  # t0 = 0x30d4
sll  $s1, $t0, 4	 # y = 0x30d40 = 200000
add  $s2, $s0, $s1       # y = x+y
