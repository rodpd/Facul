# x - s0
# y - s1
addi $s0, $zero, 1 # x = 1
add  $t0, $s0, $s0 # t0 = 2x
add  $t0, $t0, $t0 # t0 = 2x + 2x
add  $t0, $t0, $s0 # t0 = 4x + x
addi $s1, $t0, 15  # y = 5x+15