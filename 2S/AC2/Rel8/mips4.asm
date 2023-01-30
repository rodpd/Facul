# x - s0
# y - s1
# z - s2
addi $s0, $zero, 3 # x = 3
addi $s1, $zero, 4 # y = 4
sll  $t0, $s0, 4   # t0 = 16x
sub  $t0, $t0, $s0 # t0 = 15x
sll  $t1, $s1, 6   # t1 = 64y
add  $t1, $t1, $s1 # t1 = 65y
add  $t1, $t1, $s1 # t1 = 66y
add  $t1, $t1, $s1 # t1 = 67y
add  $t0, $t0, $t1 # t0 = t0+t1
add  $t0, $t0, $t0 # t0 = 2t0
add  $s2, $t0, $t0 # z = 2t0 = (15x+67y)•4
