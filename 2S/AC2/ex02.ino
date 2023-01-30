int a = 0;
int b = 0;
int vr = 13;
int am = 12;
int vd = 11;
int az = 10;
int cod;
int saida;

void setup() {
	Serial.begin(9600);     
	pinMode(vr,OUTPUT);
	pinMode(am,OUTPUT);
	pinMode(vd,OUTPUT);
	pinMode(az,OUTPUT);
}
void loop() {
	
	if (Serial.available() > 0) {

    a = Serial.parseInt();
    b = Serial.parseInt();
    cod = Serial.parseInt();

    if (Serial.read() == '\n') {
      
			digitalWrite(vr, LOW);
	    digitalWrite(am, LOW);
	    digitalWrite(vd, LOW);
	    digitalWrite(az, LOW);
	
		if ( a == 1 ) {
			digitalWrite(vr, HIGH);
		}
		
		if ( b == 1 ) {
			digitalWrite(am, HIGH);
		}
				
		if (cod == 0) {
			saida = portaand(a, b);
			if ( saida == 1 ) {
				digitalWrite(vd, HIGH);
			}
		}
		
		if (cod == 1) {
			saida = portaor(a, b);
			if ( saida == 1 ) {
				digitalWrite(vd, HIGH);
			}
		}
		
		if (cod == 2) {
			if ( a == 0 ) {
				digitalWrite(vd, HIGH);
			}
		}
		
		if (cod == 3) {
			saida = portaxor (a, b);
			if ( saida == 1 ) {
				digitalWrite(vd, HIGH);
			}
			saida = portaand (a, b);
			if ( saida == 1 ) {
				digitalWrite(az, HIGH);
			}
		}
		    }
	}
}

int portaor(int a, int b) {
	return(a|b);
}

int portaand(int a, int b) {
	return(a&b);
}

int portaxor(int a, int b) {
	return(a^b);
}
