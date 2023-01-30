ori $t0, $0, 0x01    # inicio
ori $t0, $0, 0xffff  # $8 = 0x0000ffff
sll $t0, $t0, 16     # $8 = 0xffff0000
ori $t0, $t0, 0xffff # $8 = 0xffffffff
