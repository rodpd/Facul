import keyboard
import socket


def mostrarTabuleiros(s):
    mostrarTabuleiro()
    mostrarTabuleiroInimigo(s)


def mostrarTabuleiro():
    print ("\nMeu Tabuleiro:\n   A  B  C  D  E  F  G  H  I  J")
    for i in range(10):
        if (i == 9):
            print(i+1, end = " ")
        else:
            print(i+1, end = "  ")
        for j in range(10):
            print(tabuleiro[i][j], end = "  ")
        print()
    print()


def mostrarTabuleiroInimigo(s):
    msg = "Tabuleiro"
    s.sendall(msg.encode('ascii'))
    msg = s.recv(1024).decode('ascii')
    print("Tabuleiro Inimigo:" + msg)


def montarTabuleiro(tabuleiro):

    arq = open("navios.txt", "r")

    # porta-aviao
    str =  arq.readline().split(" ")
    adicionarNavio(5, str[0], str[1], str[2][0] )
    # navio-tanque
    for i in range(2):
        str =  arq.readline().split(" ")
        adicionarNavio(4, str[0], str[1], str[2][0] )
    # contratorpedeiro
    for i in range(3):
        str =  arq.readline().split(" ")
        adicionarNavio(3, str[0], str[1], str[2][0] )
    # submarino
    for i in range(4):
        str =  arq.readline().split(" ")
        adicionarNavio(2, str[0], str[1], str[2][0] )

    arq.close()
    return tabuleiro


def adicionarNavio(tamanho, inicioHorizontal, inicioVertical, orientacao):
    linha = int(inicioHorizontal)-1
    coluna = int(ord(inicioVertical))-65
    if ( orientacao == "N"):
        for i in range(tamanho):
            tabuleiro[linha+i][coluna] = tamanho+4
    elif (orientacao == "E"):
        for i in range(tamanho):
            tabuleiro[linha][coluna+i] = tamanho+4
    elif ( orientacao == "S"):
        for i in range(tamanho):
            tabuleiro[linha-1][coluna] = tamanho+4
    elif ( orientacao == "W"):
        for i in range(tamanho):
            tabuleiro[linha][coluna-i] = tamanho+4


def atirar():
    global acertosCliente
    print("Coordenadas:", end = " ")
    keyboard.press("esc") #limpar entrada
    msg = "Jogada:" + input()
    s.sendall(msg.encode('ascii'))
    msg = s.recv(1024).decode('ascii')
    print(msg)
    # continuar tentando ate o cliente fazer uma jogada valida
    while msg == "Coordenadas invalidas" or msg == "Jogada repetida":
        print("Coordenadas:", end = " ")
        keyboard.press("esc") #limpar entrada
        msg = "Jogada:" + input()
        s.sendall(msg.encode('ascii'))
        msg = s.recv(1024).decode('ascii')
        print(msg)
    if ( msg == "Acertou!"):
        acertosCliente += 1


def receberTiro():
    global acertosServidor
    jogada = s.recv(1024).decode('ascii')
    jogada = jogada.split(" ")
    print("Recebeu ataque em", end = " ")
    print(str(int(jogada[0])+1) + " " + jogada[1])
    horizontal = int(jogada[0])
    vertical = int(ord(jogada[1]))-65
    print()
    if ( tabuleiro[horizontal][vertical] > 1 ):
        msg = "Acertou"
        acertosServidor += 1
        tabuleiro[horizontal][vertical] = tabuleiro[horizontal][vertical]-4
    else:
        msg = "Errou"
        tabuleiro[horizontal][vertical] = 1
    s.sendall(msg.encode('ascii'))



acertosCliente = 0
acertosServidor = 0
tabuleiro = [0]*10
for i in range(10):
    tabuleiro[i] = [0]*10
tabuleiro = montarTabuleiro(tabuleiro)

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print("Host/IP:", end = " ")
host = input()
print("Port:", end = ' ')
port = int(input())
s.connect((host, port))

keyboard.on_press_key("p", lambda _:mostrarTabuleiros(s))

print("COMANDOS\nJ - Iniciar Jogada\nP - Mostrar Tabuleiros\nESC - Finalizar Jogo\n")

jogoEmAndamento = True

while jogoEmAndamento:
    # iniciar jogada quando j for pressionado
    if keyboard.is_pressed("j"):
        atirar()
        receberTiro()
    # terminar jogo quando esc for pressionado
    if keyboard.is_pressed("esc") or acertosCliente == 30 or acertosServidor == 30:
        jogoEmAndamento = False

if acertosCliente == 30:
    print("Voce venceu!")
elif acertosServidor == 30:
    print("Voce perdeu :(")
mostrarTabuleiros(s)

s.close