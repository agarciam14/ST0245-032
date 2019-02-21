#define POT 0

const int LedRojo =  5;
const int LedAmarillo =  4;
const int LedAzul =  3;
const int LedVerde =  2;

unsigned int voltaje = 0;


void setup() {
 Serial.begin(9600);
 pinMode (LedRojo, OUTPUT);
 pinMode (LedAmarillo, OUTPUT);
 pinMode (LedAzul, OUTPUT);
 pinMode (LedVerde, OUTPUT);
}

void loop() {
  voltaje = analogRead(POT);
  Serial.print("Voltaje del potenciometro: ");
  Serial.println(voltaje);
  delay(500);

  if(voltaje > 0 && voltaje <= 255)
    digitalWrite(LedRojo, HIGH);
    else 
    digitalWrite(LedRojo, LOW);
    
  if(voltaje > 255 && voltaje <= 510)
    digitalWrite(LedAmarillo, HIGH);
  	else 
    digitalWrite(LedAmarillo, LOW);
  
  if(voltaje > 510 && voltaje <= 765)
    digitalWrite(LedAzul, HIGH);
  	else 
    digitalWrite(LedAzul, LOW);
  
  if(voltaje > 765 && voltaje <= 1023)
    digitalWrite(LedVerde, HIGH);
  	else 
    digitalWrite(LedVerde, LOW);
 
}
