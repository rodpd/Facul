#INCLUDE <P16F628A.INC>		;ARQUIVO PADR?O MICROCHIP PARA 16F628A
RADIX DEC
__CONFIG H'3F10'

	CBLOCK	0x20	;ENDERE?O INICIAL DA MEM?RIA DE USU?RIO
	CONTADOR1	
	ENDC			;FIM DO BLOCO DE MEM?RIA		

#DEFINE	BOTAO	PORTA,2	;PORTA DO BOT?O
					; 0 -> PRESSIONADO
					; 1 -> LIBERADO

#DEFINE	LED	PORTB,0	;PORTA DO LED
				; 0 -> APAGADO
				; 1 -> ACESO
	ORG	0x00		;ENDERE?O INICIAL DE PROCESSAMENTO
	GOTO	INICIO
	
INICIO
	CLRF	PORTA		;LIMPA O PORTA
	CLRF	PORTB		;LIMPA O PORTB
	BSF STATUS, RP0			;ALTERA PARA O BANCO 1
	MOVLW	B'00000100'
	MOVWF	TRISA		;DEFINE RA2 COMO ENTRADA E DEMAIS COMO SA?DAS
	CLRF	TRISB		;DEFINE TODO O PORTB COMO SA?DA
	CLRF	INTCON		;TODAS AS INTERRUP??ES DESLIGADAS
	BCF STATUS, RP0 ;RETORNA PARA O BANCO 0
	MOVLW	B'00000111'
	MOVWF	CMCON		;DEFINE O MODO DO COMPARADOR ANAL?GICO

MAIN

	BTFSC	BOTAO		;O BOT?O EST? PRESSIONADO?
	GOTO	BOTAO_LIB	;N?O, ENT?O TRATA BOT?O LIBERADO
	GOTO	BOTAO_PRES	;SIM, ENT?O TRATA BOT?O PRESSIONADO

BOTAO_LIB
	BCF	LED		;APAGA O LED
	GOTO 	MAIN		;RETORNA AO LOOP PRINCIPAL

BOTAO_PRES
	BSF	LED		;ACENDE O LED
	GOTO 	MAIN		;RETORNA AO LOOP PRINCIPAL


	END			;OBRIGAT?RIO


