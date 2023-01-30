// Definiçao de valores para variáveis  
int led10 = 10;
int led11 = 11;
int led12 = 12;
int led13 = 13;
int entrada;


// Rotina executada 1 vez e que em geral configura entradas e saídas 
void setup() {                
	// configura os pinos como saídas DIGITAIS.
	Serial.begin(9600);
	pinMode(led10, OUTPUT);
	pinMode(led11, OUTPUT);
	pinMode(led12, OUTPUT);
	pinMode(led13, OUTPUT);
	
}

// the loop routine runs over and over again forever:
void loop() {
	
	if ( Serial.available() > 0 ) {
		
		entrada = Serial.parseInt();
		
		if ( Serial.read() == '\n' ) {
		
		if ( entrada == 0 ) {
			digitalWrite(led10,HIGH);
			digitalWrite(led11,LOW);
			digitalWrite(led12,LOW);
			digitalWrite(led13,HIGH);
			//delay(900);
		}
		
		if ( entrada == 1 ) {
			digitalWrite(led10,LOW);
			digitalWrite(led13,HIGH);
			//delay(100);
		}
		
		if ( entrada == 2 ) {
			digitalWrite(led10,HIGH);
			digitalWrite(led11,HIGH);
			digitalWrite(led12,LOW);
			digitalWrite(led13,LOW);
			//delay(900);
		}
		
		if ( entrada == 3 ) {
			digitalWrite(led10,LOW);
			digitalWrite(led11,HIGH);
			//delay(100);
		}
		
		if ( entrada == 4 ) {
			digitalWrite(led10,HIGH);
			digitalWrite(led11,LOW);
			digitalWrite(led12,HIGH);
			digitalWrite(led13,LOW);
			//delay(900);
		}
		
		if ( entrada == 5 ) {
			digitalWrite(led10,LOW);
			digitalWrite(led12,HIGH);
			//delay(100);
		}
	}
	}
}
