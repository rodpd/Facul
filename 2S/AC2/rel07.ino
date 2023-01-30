int a;
int b;
int s0;
int s1;
int s2;
int s3;
char opcode;
String str;

int led10 = 10;
int led11 = 11;
int led12 = 12;
int led13 = 13;
int saida;

void setup() {
	Serial.begin(9600);     
	pinMode(led10,OUTPUT);
	pinMode(led11,OUTPUT);
	pinMode(led12,OUTPUT);
	pinMode(led13,OUTPUT);
}

void loop() {
	
	if (Serial.available() > 0) {
		
		str = Serial.readString();
		a = hexa(str.charAt(0));
		b = hexa(str.charAt(1));
		opcode = str.charAt(2);
		//testes leitura
/*Serial.print("str: ");
		Serial.println(str);
		Serial.print("a: ");
		Serial.println(a);
		Serial.print("b: ");
		Serial.println(b);
		Serial.print("opcode: ");
		Serial.println(opcode);*/		
		
		//if (Serial.read()=='\n') {
		// 0 logico
		if ( opcode == '0' ) {
			saida = 0;
			calcular(saida);
		}
		// 1 logico
		else if ( opcode == '1' ) {
			saida = 0xf;
			calcular(saida);
		}
		// not a
		else if ( opcode == '2' ) {
			saida = portanot(a);
			calcular(saida);
		}
		// not b
		else if ( opcode == '3' ) {
			saida = portanot(b);
			calcular(saida);
		}
		// a or b
		else if ( opcode == '4' ) {
			saida = portaor(a,b);
			calcular(saida);
		}
		// a and b
		else if ( opcode == '5' ) {
			saida = portaand(a,b);
			calcular(saida);
		}
		// a nor b
		else if ( opcode == '6' ) {
			saida = portaxor(a,b);
			calcular(saida);
		}
		// a nand b
		else if ( opcode == '7' ) {
			saida = portaand(a,b);
			saida = portanot(saida);
			calcular(saida);
		}
		// a nor b
		else if ( opcode == '8' ) {
			saida = portaor(a,b);
			saida = portanot(saida);
			calcular(saida);
		}
		// a xnor b
		else if ( opcode == '9' ) {
			saida = portaxor(a,b);
			saida = portanot(saida);
			calcular(saida);
		}
		// not a or b
		else if ( opcode == 'A' ) {
			a = portanot(a);
			saida = portaor(a,b);
			calcular(saida);
		}
		// a or not b
		else if ( opcode == 'B' ) {
			b = portanot(b);
			saida = portaor(a,b);
			calcular(saida);
		}
		// not a and b
		else if ( opcode == 'C' ) {
			a = portanot(a);
			saida = portaand(a,b);
			calcular(saida);
		}
		// a and not b
		else if ( opcode == 'D' ) {
			b = portanot(b);
			saida = portaand(a,b);
			calcular(saida);
		}
		// not a or not b
		else if ( opcode == 'E' ) {
			a = portanot(a);
			b = portanot(b);
			saida = portaor(a,b);
			calcular(saida);
		}
		// not a and not b
		else if ( opcode == 'F' ) {
			a = portanot(a);
			b = portanot(b);
			saida = portaand(a,b);
			calcular(saida);
		}
		//} 
	}
}

void calcular ( int resultado ) {
	
	s0 = bitRead(resultado , 0);
	s1 = bitRead(resultado , 1);
	s2 = bitRead(resultado , 2);
	s3 = bitRead(resultado , 3);
	// ligar ou desligar leds dependendo do resultado
	if ( s0 == 0 ) {
		digitalWrite(led10, LOW);
	}
	else {
		digitalWrite(led10, HIGH);
	}
	if ( s1 == 0 ) {
		digitalWrite(led11, LOW);
	}
	else {
		digitalWrite(led11, HIGH);
	}
	if ( s2 == 0 ) {
		digitalWrite(led12, LOW);
	}
	else {
		digitalWrite(led12, HIGH);
	}
	if ( s3 == 0 ) {
		digitalWrite(led13, LOW);
	}
	else {
		digitalWrite(led13, HIGH);
	}
}

int hexa ( char c ) {
	int n = 0;
	if ( c == '0' ) {
		n = 0;
	}
	else if ( c == '1' ) {
		n = 1;
	}
	else if ( c == '2' ) {
		n = 2;
	}
	else if ( c == '3' ) {
		n = 3;
	}
	else if ( c == '4' ) {
		n = 4;
	}
	else if ( c == '5' ) {
		n = 5;
	}
	else if ( c == '6' ) {
		n = 6;
	}
	else if ( c == '7' ) {
		n = 7;
	}
	else if ( c == '8' ) {
		n = 8;
	}
	else if ( c == '9' ) {
		n = 9;
	}
	else if ( c == 'A' ) {
		n = 0xA;
	}
	else if ( c == 'B' ) {
		n = 0xB;
	}
	else if ( c == 'C' ) {
		n = 0xC;
	}
	else if ( c == 'D' ) {
		n = 0xD;
	}
	else if ( c == 'E' ) {
		n = 0xE;
	}
	else if ( c == 'F' ) {
		n = 0xF;
	}
	return n;
}

int portaxor(int a, int b)
{
	return(a^b);
}

int portaor(int a, int b)
{
	return(a|b);
}

int portaand(int a, int b)
{
	return(a&b);
}

int portanot(int a)
{
	return(0xF - a);
}