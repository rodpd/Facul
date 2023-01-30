import random
import socket


def montarTabuleiro(tabuleiro):
    
    # porta-aviao
    adicionarNavio(5)
    # navio-tanque
    for i in range(2):
        adicionarNavio(4)
    # contratorpedeiro
    for i in range(3):
        adicionarNavio(3)
    # submarino
    for i in range(4):
        adicionarNavio(2)

    return tabuleiro


def adicionarNavio(tamanho):
    invalido = 1
    while ( invalido ):
        invalido = 0
        linha = random.randrange(0,9)
        coluna = random.randrange(0,9)
        orientacao = random.randrange(0,3)
        # verificar se nao esta passando dos limites do tabuleiro
        if ( (orientacao == 0 and linha-tamanho < -1)
            or (orientacao == 1 and coluna+tamanho > 10)
            or (orientacao == 2 and linha+tamanho > 10)
            or (orientacao == 3 and coluna-tamanho < -1)):
            invalido += 1

        # verificar se ja tem algum navio nas posicoes escolhidas
        if ( not invalido ):
            if ( orientacao == 0):
                for i in range(tamanho):
                    invalido += tabuleiro[linha-i][coluna]
            elif (orientacao == 1):
                for i in range(tamanho):
                    invalido += tabuleiro[linha][coluna+i]
            elif ( orientacao == 2):
                for i in range(tamanho):
                    invalido += tabuleiro[linha+i][coluna]
            else:
                for i in range(tamanho):
                    invalido += tabuleiro[linha][coluna-i]

    # adicionar navio ao tabuleiro
    if ( orientacao == 0):
        for i in range(tamanho):
            tabuleiro[linha-i][coluna] = tamanho+4
    elif (orientacao == 1):
        for i in range(tamanho):
            tabuleiro[linha][coluna+i] = tamanho+4
    elif ( orientacao == 2):
        for i in range(tamanho):
            tabuleiro[linha+i][coluna] = tamanho+4
    else:
        for i in range(tamanho):
            tabuleiro[linha][coluna-i] = tamanho+4


# monta a mensagem com as informacoes do tabuleiro, trocando as posicoes dos barcos por 0
def enviarTabuleiro(c):
    msg = ""
    for i in range(10):
        if i == 9:
            msg += str(i+1) + " "
        else:
            msg += str(i+1) + "  "
        for j in range(10):
            msg += (str(tabuleiro[i][j]) + "  ")
        msg += "\n"
    msg = msg.replace("6","0")
    msg = msg.replace("7","0")
    msg = msg.replace("8","0")
    msg = msg.replace("9","0")
    msg = msg [0:170] + '6' + msg[171:]
    msg = msg [0:204] + '7' + msg[205:]
    msg = msg [0:238] + '8' + msg[239:]
    msg = msg [0:272] + '9' + msg[273:]
    msg = "\n   A  B  C  D  E  F  G  H  I  J\n" + msg
    c.sendall(msg.encode('ascii'))


def jogadaAleatoria():
    linha = random.randrange(1,10)
    coluna = random.randrange(0,9)
    coordenadas = str(linha)+ " " + str(coluna)
    # continuar gerando outras coordenadas ate nao ser uma repetida
    while coordenadas in jogadasFeitas:
        linha = random.randrange(1,10)
        coluna = random.randrange(0,9)
        coordenadas = str(linha) + " " + str(coluna)
    coordenadas = str(linha) + " " + chr(coluna+65)
    return coordenadas


def atirar():
    global ultimaJogada
    global acertosServidor
    # se tiver acertado, atirar em um vizinho da ultima jogada
    if ultimaJogada:
        linha = int((ultimaJogada.split(" ")[0]))
        coluna = int(ord(ultimaJogada.split(" ")[1]))-65
        # atirar ao norte
        if linha - 1 >= 0 and str(linha-1)+" "+chr(coluna+65) not in jogadasFeitas:
            coordenadas = str(linha-1)+" "+chr(coluna+65)
        # atirar ao sul
        elif linha + 1 <= 9 and str(linha+1)+" "+chr(coluna+65) not in jogadasFeitas:
            coordenadas = str(linha+1)+" "+chr(coluna+65)
        # atirar a leste
        elif coluna + 1 <= 9 and str(linha)+" "+chr(coluna+66) not in jogadasFeitas:
            coordenadas = str(linha)+" "+chr(coluna+66)
        # atirar a oeste
        elif coluna - 1 >= 0 and str(linha)+" "+chr(coluna+64) not in jogadasFeitas:
            coordenadas = str(linha)+" "+chr(coluna+64)
        # se os vizinhos ja tiverem sido alvejados, gerar jogada aleatoria
        else:
            coordenadas = jogadaAleatoria()
    # gerar jogada aleatoria se a ultima nao tiver acertado nada
    else:
        coordenadas = jogadaAleatoria()
    jogadasFeitas.append(coordenadas)
    msg = coordenadas
    c.sendall(msg.encode('ascii'))
    msg = c.recv(1024).decode('ascii')
    if ( msg == "Acertou"):
        acertosServidor += 1
        ultimaJogada = coordenadas
    else:
        ultimaJogada = ""

def receberTiro(c, coordenadas):
    global acertosCliente
    try:
        coordenadas = coordenadas.split(" ")
        horizontal = int(coordenadas[0])-1
        vertical = int(ord(coordenadas[1]))-65
        if tabuleiro[horizontal][vertical] > 5:
            tabuleiro[horizontal][vertical] = tabuleiro[horizontal][vertical] - 4
            acertosCliente += 1
            msg = "Acertou!"
            c.sendall(msg.encode('ascii'))
            atirar()
        elif tabuleiro[horizontal][vertical] == 0:
            tabuleiro[horizontal][vertical] = 1
            msg = "Errou!"
            c.sendall(msg.encode('ascii'))
            atirar()
        else:
            msg = "Jogada repetida"
            c.sendall(msg.encode('ascii'))
    except:
        msg = "Coordenadas invalidas"
        c.sendall(msg.encode('ascii'))


arq = open("navios.txt", "r")

tabuleiro = [0]*10
for i in range(10):
    tabuleiro[i] = [0]*10
tabuleiro = montarTabuleiro(tabuleiro)

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)         # Create a socket object
host = socket.gethostname() # Get local machine name
print("Port:", end = " ")
port = int(input())
s.bind((host, port))        # Bind to the port

s.listen(5)                 # Now wait for client connection.
addr = None
print("Aguardando conexao")
while addr == None:
    c, addr = s.accept()     # Establish connection with client.
    print ("Conectado a %s"%(addr[0]))

jogoEmAndamento = True
acertosCliente = 0
acertosServidor = 0
jogadasFeitas = []
ultimaJogada = ""

while jogoEmAndamento:
    msg = c.recv(1024).decode('ascii')
    if ( msg == "Tabuleiro"):
        enviarTabuleiro(c)
    elif ( msg[0:6] == "Jogada"):
        receberTiro(c, msg[7:].upper())

c.close()                # Close the connection