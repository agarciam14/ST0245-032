//potenciometro conectado al pin A0
#define POT 0

//se declara el pin de cada led
const int LedRojo =  5;
const int LedAmarillo =  4;
const int LedAzul =  3;
const int LedVerde =  2;

//variables
float valor = 0; //variable para almacenar el valor del potenciometro
float voltaje = 0; //variable para guardar la conversión a voltios 

void setup() {
 //iniciamos la comunicación serial
 Serial.begin(9600);
 //configuración de los pines como salida
 pinMode (LedRojo, OUTPUT);
 pinMode (LedAmarillo, OUTPUT);
 pinMode (LedAzul, OUTPUT);
 pinMode (LedVerde, OUTPUT);
}

void loop() {
  valor = analogRead(POT); //se lee el valor del potenciometro y se almacena en esta variable
  voltaje = (valor * 5)/1000; //conversión del valor en voltios
  Serial.print("Voltaje del potenciometro: "); 
  Serial.print(voltaje);
  Serial.println("V");
  delay(500); //retardo de 500ms

  if(valor > 0 && valor <= 255)  //condición que enciende y apaga el led rojo
    digitalWrite(LedRojo, HIGH);
    else 
    digitalWrite(LedRojo, LOW);
    
  if(valor > 255 && valor <= 510) //condición que enciende y apaga el led amarillo
    digitalWrite(LedAmarillo, HIGH);
    else 
    digitalWrite(LedAmarillo, LOW);
  
  if(valor > 510 && valor <= 765) //condición que enciende y apaga el led azul
    digitalWrite(LedAzul, HIGH);
    else 
    digitalWrite(LedAzul, LOW);
  
  if(valor > 765 && valor <= 1023) //condición que enciende y apaga el led verde
    digitalWrite(LedVerde, HIGH);
    else 
    digitalWrite(LedVerde, LOW);
 
}
