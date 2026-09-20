# Solucionario Integral: Taller Gamificado de POO en Java (Paginas 1-39)

Este documento contiene la solucion exhaustiva, tecnica y formal de cada una de las actividades, ejemplos base, preguntas guiadas PRIMM, predicciones relampago, cazabugs, retos practicos y la batalla final del taller de Programacion Orientada a Objetos en Java.

---

## Indice de Contenidos

1. [Sesion 0: Arranque y Entorno](#sesion-0-arranque-y-entorno)
2. [Nivel 1: La Forja de Heroes (Clases, Atributos, New y Metodos)](#nivel-1-la-forja-de-heroes)
3. [Nivel 2: La Boveda del Gremio (Constructores, Encapsulamiento y Visibilidad)](#nivel-2-la-boveda-del-gremio)
4. [Nivel 3: El Linaje (Herencia, Super, Protected y @Override)](#nivel-3-el-linaje)
5. [Nivel 4: La Arena de los Mil Rostros (Polimorfismo, Enlace Dinamico y Sobrecarga)](#nivel-4-la-arena-de-los-mil-rostros)
6. [Nivel 5: El Escuadron Sellado (Agregacion, ArrayList y Modificador Final)](#nivel-5-el-escuadron-sellado)
7. [Jefe Final: Batalla contra el Dragon Null](#jefe-final-batalla-contra-el-dragon-null)
8. [Consolidado de los 13 Bugs del Taller (Cazabugs)](#consolidado-de-los-13-bugs-del-taller)
9. [Cierre: Ticket de Salida 3-2-1 e Insignias](#cierre-ticket-de-salida-3-2-1-e-insignias)

---

## Sesion 0: Arranque y Entorno

### 1. Programa Inicial
- Archivo fuente: `com.taller.sesion0.ProgramaInicial`
- Codigo implementado:
```java
public class ProgramaInicial {
    public static void main(String[] args) {
        String equipo = "LosNullPointers";
        System.out.println("Hola, somos " + equipo + " y venimos a forjar objetos");
    }
}
```

### 2. Calentamiento: Clase u Objeto
1. **Estudiante**: **Clase**. Es el molde conceptual general que define que datos y comportamientos tendra cualquier alumno.
2. **El computador que usa tu equipo ahora**: **Objeto**. Es una instancia concreta, fisica y unica con estado particular en memoria y procesador.
3. **Cancion**: **Clase**. Es la definicion generica (plantilla de titulo, compositor, duracion).
4. **La ultima cancion que escucho el Navegante**: **Objeto**. Es una instancia especifica reproducida en un momento temporal definido.
5. **Celular**: **Clase**. Es el modelo de diseno o especificacion de fabricacion.

---

## Nivel 1: La Forja de Heroes

### Ejemplo Base 1: El Molde y sus Objetos
- Archivo fuente: `com.taller.nivel1.EjemploBase1`
- Concepto: Declaracion de la clase `Heroe` con atributos de estado (`nombre`, `vida`, `ataque`) y comportamiento con el metodo `saludar()`.
- Instanciacion con `new`: Se construyen dos instancias independientes en el Heap: `kira` y `taro`.

### Ejemplo Base 2: Metodos que Hacen y Responden
- Archivo fuente: `com.taller.nivel1.EjemploBase2`
- Metodos evaluados:
  - `void recibirDanio(int danio)`: Metodo mutador sin retorno que modifica el estado interno.
  - `boolean estaVivo()`: Metodo de consulta que evalua la condicion `vida > 0`.
  - `int golpeCritico()`: Metodo de calculo que devuelve el doble del atributo `ataque`.

### Practica Guiada PRIMM
- Archivo fuente: `com.taller.nivel1.PracticaPRIMM1`
1. **Predice**: Si se cambia `kira.recibirDanio(30)` por `kira.recibirDanio(120)`:
   - Primera linea (`vida`): `100 - 120 = -20`.
   - Tercera linea (`estaVivo()`): `-20 > 0` evalua a `false`.
2. **Ejecuta**: Coincide exactamente. Vida negativa no tiene sentido logico en el dominio de un videojuego; este defecto demuestra la necesidad del encapsulamiento implementado en el Nivel 2.
3. **Investiga**: Al invocar `fantasma.saludar()` sin asignar valores:
   - Imprime: `Soy null, vida 0`.
   - Causa: En Java, los atributos de instancia no inicializados toman valores por defecto: tipos de referencia (`String`) inician en `null`, y tipos numericos primitivos (`int`) inician en `0`.
4. **Modifica**: Se anade `void curar(int puntos) { vida = vida + puntos; }`. Al llamar `kira.curar(50)` partiendo de vida `-20`, la vida resultante es `-20 + 50 = 30`.

### Predicciones Relampago Nivel 1
- **Prediccion A**:
  - Codigo: `Heroe a = new Heroe(); a.vida = 50; Heroe b = a; b.vida = 10; System.out.println(a.vida);`
  - Salida: `10`.
  - Justificacion: Las variables `a` y `b` son referencias que apuntan a la misma direccion de memoria en el Heap. Solo existe un objeto creado con `new`.
- **Prediccion B**:
  - Codigo: `Heroe x = new Heroe(); x.ataque = 7; x.ataque = x.golpeCritico(); int r = x.golpeCritico(); System.out.println(r);`
  - Salida: `28`.
  - Justificacion: `x.golpeCritico()` inicial es `7 * 2 = 14`. El atributo `x.ataque` toma el valor `14`. Luego `r = 14 * 2 = 28`.
- **Prediccion C**:
  - Codigo: `Heroe z = new Heroe();`
  - Salida (3 lineas):
    `null`
    `0`
    `false`

### Cazabugs Nivel 1
- Archivo fuente: `com.taller.nivel1.CazabugsNivel1`
- **Bug 1 (Linea 3 original)**: `Heroe luna;` no inicializa el objeto, provocando error de variable local no inicializada.
  - Correccion: `Heroe luna = new Heroe();`
- **Bug 2 (Linea 11 original)**: `void saludar()` define tipo de retorno `void` pero ejecuta una sentencia `return "Hola, soy " + nombre;`.
  - Correccion: Declarar tipo de retorno `String saludar()`.

### Retos del Nivel 1
- **Reto 1.1: Mascota Digital** (`com.taller.nivel1.Reto1_1_MascotaDigital`):
  - Clase `Mascota` con `energia` inicial 60.
  - Dos llamadas a `jugar()` restan 30 puntos (saldo 30).
  - Una llamada a `comer(20)` suma 20 puntos (saldo 50).
  - `estado()` evalua `energia >= 50` y retorna `"Feliz"`.
- **Reto 1.2: Tu Heroe, tus Datos** (`com.taller.nivel1.Reto1_2_HeroeDatosReales`):
  - Atributos reales: nombre `"JAC"`, vida `43`, ataque `6`.
  - Metodo `int golpesParaVencer(int vidaEnemigo)` implementado con ciclo `while`.
  - Contra 100 HP: Requiere 17 golpes (17 * 6 = 102).
  - Contra 250 HP: Requiere 42 golpes (42 * 6 = 252).
- **Reto 1.3: El Clon Honesto** (`com.taller.nivel1.Reto1_3_ClonHonesto`):
  - Metodo `Heroe clonar()` genera una nueva instancia independiente con `new`.
  - Al reducir en 50 la vida del clon, la vida del original permanece inalterada en 100, evidenciando separacion fisica en el Heap.

---

## Nivel 2: La Boveda del Gremio

### Ejemplo Base 3: El Constructor y Sobrecarga
- Archivo fuente: `com.taller.nivel2.EjemploBase3`
- Reglas del constructor:
  - Mismo nombre que la clase, sin tipo de retorno ni `void`.
  - Uso de `this.atributo` para resolver ambiguedad frente al identificador del parametro.
  - Delegacion de constructores con `this(...)`, la cual debe ser obligatoriamente la primera sentencia ejecutable.

### Ejemplo Base 4: Encapsulamiento y Control de Invariantes
- Archivo fuente: `com.taller.nivel2.EjemploBase4`
- Atributos `private String nombre` y `private int vida`.
- `setVida(int vida)` aplica validacion defensiva:
  - Si `vida < 0`: se ajusta a `0`.
  - Si `vida > 150`: se ajusta a `150`.
  - En cualquier otro caso: asigna el valor directo.

### Practica Guiada PRIMM
- Archivo fuente: `com.taller.nivel2.PracticaPRIMM2`
1. **Predice**: Quitar `//` en `kira.vida = 9999;` resulta en: `(c) no compila`.
2. **Ejecuta**: Mensaje del compilador: `vida has private access in Heroe`.
3. **Investiga**: `Heroe nadie = new Heroe();` no compila porque al definir manualmente constructores con argumentos, Java suprime la generacion del constructor vacio por defecto.
4. **Modifica**: `recibirDanio(int danio)` llama a `setVida(vida - danio)`. Al partir de 80 y recibir 200 de danio, el setter ajusta el resultado a 0 impidiendo estados negativos.

### Predicciones Relampago Nivel 2
- **Prediccion A**:
  - `Cofre c = new Cofre();` llama a `this(50)`, asignando `50 * 2 = 100`. Salida: `100`.
- **Prediccion B**:
  - `Gema g = new Gema(30);` contiene `valor = valor;`. El parametro se asigna a si mismo (shadowing). El atributo `this.valor` queda en 0. Salida: `0`.
- **Prediccion C**:
  - `Heroe rin = new Heroe("Rin", 80); rin.setVida(rin.getVida() + 100);` resulta en `80 + 100 = 180`, que el setter restringe a 150. Salida: `150`.

### Cazabugs Nivel 2
- Archivo fuente: `com.taller.nivel2.CazabugsNivel2`
- **Bug 3 (Linea 12 original)**: `public void Arma(String nombre, int danio)` incluye `void`, convirtiendose en un metodo ordinario y dejando a la clase sin constructor coincidente.
  - Correccion: Quitar `void` -> `public Arma(String nombre, int danio)`.
- **Bug 4 (Linea 13 original)**: `nombre = nombre;` incurre en sombreado de parametros sin modificar el atributo.
  - Correccion: Usar `this.nombre = nombre;`.
- **Bug 5 (Linea 21 original)**: `private int getDanio()` impide el acceso publico desde `Main`.
  - Correccion: Modificar visibilidad a `public int getDanio()`.
- (Correccion tipografica adicional: `getN ombre()` a `getNombre()`).

### Retos del Nivel 2
- **Reto 2.1: La Boveda del Gremio** (`com.taller.nivel2.Reto2_1_CuentaGremio`):
  - Metodos `depositar(int monto)` y `boolean retirar(int monto)`.
  - Secuencia de prueba: Depositar 500, depositar -100 (ignorado), retirar 800 (falla, false), retirar 200 (exitoso, true).
  - Salida verificada: `false`, `true`, saldo final `300`.
  - Justificacion de la ausencia de `setSaldo`: Prohibido porque violaria la integridad de la cuenta, permitiendo inyecciones arbitrarias de saldo sin trazabilidad.
- **Reto 2.2: Contrasena Blindada** (`com.taller.nivel2.Reto2_2_UsuarioBlindado`):
  - Usuario: `"Mateo"`, contrasena inicial: `"losnullpointers4"`.
  - `cambiarClave` verifica clave actual via `.equals()` y exige longitud `>= 8` mediante `.length()`.
  - No existe `getClave()`.
- **Reto 2.3: Tres Formas de Nacer** (`com.taller.nivel2.Reto2_3_Pociones`):
  - Clase `Pocion` con tres constructores encadenados.
  - Constructores 1 y 2 delegan con `this(...)` hacia el tercer constructor, unico responsable de la asignacion final.

---

## Nivel 3: El Linaje

### Ejemplo Base 5 y 6: Herencia y Sobrescritura
- Archivos fuente: `com.taller.nivel3.EjemploBase5` y `com.taller.nivel3.EjemploBase6`
- Clase padre `Personaje` con visibilidad `protected` para permitir acceso directo a clases hijas.
- Clases `Guerrero` y `Mago` heredan con `extends` y llaman al constructor padre con `super(nombre, vida, ataque)`.
- `Guerrero` sobrescribe `presentarse()` usando `@Override` y reutiliza el comportamiento base mediante `super.presentarse()`.

### Practica Guiada y Predicciones Nivel 3
- Archivo fuente: `com.taller.nivel3.PracticaPRIMM3`
1. **Borrar super(...)**: El compilador busca `Personaje()` por defecto, arrojando error al no existir.
2. **Protected vs Private**: Cambiar `nombre` a `private` impide que `Guerrero.defender()` compile. `presentarse()` si funciona porque reside en `Personaje`.
3. **Prediccion A**: Jerarquia `A -> B -> C` ejecuta constructores en cascada desde el ancestro raiz: Salida: `A`, `B`, `C`.
4. **Prediccion B**: `Gato.sonido()` concatena `"Miau"` con `super.sonido()`: Salida: `Miau...`.
5. **Prediccion C**: `lira.defender()` no compila porque `defender()` no existe en `Mago` ni en `Personaje`.

### Rompecabezas del Linaje
- Archivo fuente: `com.taller.nivel3.RompecabezasLinaje`
- Trampas detectadas y descartadas:
  - `public void Sanador(...)`: Lleva `void`, desnaturalizando el constructor.
  - `class Sanador implements Personaje`: `implements` aplica exclusivamente a interfaces, no a clases.
- Ensamblado correcto: Clase `Sanador` derivada de `Personaje` con atributo `hierbas`, constructor con llamada `super(n, v, a)` y metodo `presentarse()` con `@Override`.

### Cazabugs Nivel 3
- Archivo fuente: `com.taller.nivel3.CazabugsNivel3`
- **Bug 6 (Linea 21 original)**: Constructor de `Grifo` omite llamada explicita al constructor padre con parametros.
  - Correccion: Incluir `super(velocidad);` como primera instruccion.
- **Bug 7 (Linea 26 original)**: Typo en `@Override public void mostar()`.
  - Correccion: Corregir identificador a `public void mostrar()`.
- **Bug 8 (Linea 27 original)**: `velocidad` es `private` en `Montura`, inaccesible directamente por la subclase.
  - Correccion: Declarar `protected int velocidad` en `Montura`.

### Retos del Nivel 3
- **Reto 3.1: Nace el Arquero** (`com.taller.nivel3.Reto3_1_Arquero`):
  - Atributo privado `flechas`. Constructor con llamada `super(...)`.
  - Metodo `disparar()` descuenta municion hasta agotarla.
- **Reto 3.2: El Arbol del Gremio en UML** (`com.taller.nivel3.Reto3_2_DiagramaUML`):
  - Diagrama formal de clases con simbolos UML: `+` (public), `-` (private), `#` (protected) y flecha de generalizacion con triangulo vacio (`^`).
- **Reto 3.3: Grito de Guerra** (`com.taller.nivel3.Reto3_3_GritoGuerra`):
  - Sobrescritura de `presentarse()` en `Guerrero`, `Mago` y `Arquero`.
  - Cada clase reutiliza `super.presentarse()` e incorpora el grito del gremio con su atributo distintivo.

---

## Nivel 4: La Arena de los Mil Rostros

### Ejemplo Base 7 y 8: Polimorfismo y Despacho Dinamico
- Archivos fuente: `com.taller.nivel4.EjemploBase7` y `com.taller.nivel4.EjemploBase8`
- Arreglo polimorfico `Personaje[] arena` donde residen instancias de `Guerrero`, `Mago` y `Personaje`.
- En tiempo de ejecucion, la JVM determina el metodo correspondiente al objeto real en memoria Heap (enlace dinamico).
- Distincion entre tipo estatico (etiqueta) y tipo dinamico (instancia real):
  - La etiqueta determina la disponibilidad en compilacion.
  - El objeto determina la version ejecutada en runtime.

### Practica Guiada y Predicciones Nivel 4
- Archivo fuente: `com.taller.nivel4.PracticaPRIMM4`
1. **Nox en la arena**: Ataque 20 duplicado por mago (`20 * 2 = 40`). Danio total acumulado: `47 + 40 = 87`.
2. **Sin @Override en Guerrero**: Brako produce 15 (ataque base heredado de `Personaje`) en vez de 20.
3. **Prediccion A**: `pA.atacar()` ejecuta version de Guerrero: Salida: `20`.
4. **Prediccion B**: Suma polimorfica de `Mago A (8) + Mago B (8) + Guerrero C (9)`: Salida: `25`.
5. **Prediccion C**: Sobrecarga en `Dado.tirar()` y `Dado.tirar(20)`: Salidas: `d6` y `d20`.

### Cazabugs Nivel 4
- Archivo fuente: `com.taller.nivel4.CazabugsNivel4`
- **Bug 9 (Linea 6 original)**: `@Override public int atacar(int bonus)` altera la firma del metodo base; es sobrecarga y el compilador rechaza `@Override`.
  - Correccion: Quitar el parametro o remover la anotacion.
- **Bug 10 (Linea 12 original)**: `arena[2]` no se instancia, permaneciendo en `null` y provocando `NullPointerException` en el for.
  - Correccion: Instanciar un objeto valido en `arena[2]`.
- **Bug 11 (Linea 20 original)**: Downcasting invalido `(Mago) arena[1]` cuando `arena[1]` es un `Guerrero`, arrojando `ClassCastException`.
  - Correccion: Proteger con `instanceof` o aplicar el cast sobre la posicion 0.

### Retos del Nivel 4
- **Reto 4.1: El Arquero entra a la Arena** (`com.taller.nivel4.Reto4_1_ArqueroArena`):
  - En la ronda 1, el arquero gasta su flecha e inflige `8 * 3 = 24`. Danio total: 71.
  - En la ronda 2, al no tener flechas, inflige 1. Danio total: 48.
- **Reto 4.2: Figuras de tu Mesa** (`com.taller.nivel4.Reto4_2_FigurasMesa`):
  - Clase abstracta/base `Figura` y derivadas `Circulo`, `Rectangulo` y `Triangulo`.
  - Calculo polimorfico del area total en un unico bucle `for`.
- **Reto 4.3: Furia Sobrecargada** (`com.taller.nivel4.Reto4_3_FuriaSobrecargada`):
  - Sobrecarga de `atacar(int furia)` en Guerrero y `atacar(boolean critico)` en Mago.
  - Explicacion de no compilacion de `p.atacar(10)`: La referencia `p` es de tipo `Personaje`, y dicha clase no define una firma que acepte enteros.

---

## Nivel 5: El Escuadron Sellado

### Ejemplo Base 9 y 10: Agregacion y Modificador Final
- Archivos fuente: `com.taller.nivel5.EjemploBase9` y `com.taller.nivel5.EjemploBase10`
- Agregacion: `Escuadron` almacena una coleccion `ArrayList<Personaje>` creada y gestionada independientemente. Al anular la variable `alfa = null`, los objetos `brako` y `lira` persisten en memoria.
- `final class Reglas`: Impide que cualquier clase extienda las reglas.
- `static final`: Define constantes globales inmutables.
- `final String nombre`: Atributo inmutable asignado unicamente en constructor.
- `final getNombre()`: Metodo blindado contra sobrescritura.

### Practica Guiada y Predicciones Nivel 5
- Archivo fuente: `com.taller.nivel5.PracticaPRIMM5`
1. **Supervivencia de partes**: Brako sigue existiendo tras disolver el escuadron.
2. **Instancia unica**: Compartir a Brako entre dos escuadrones mantiene una unica direccion Heap.
3. **Prediccion A**: `k.recibirDanio(40)` reduce la vida a 60 en la instancia compartida; la suma de ambos escuadrones arroja `60 + 60 = 120`.
4. **Prediccion B**: `monedas = monedas + 5;` arroja error de compilacion al ser `final`.
5. **Prediccion C**: `final ArrayList` permite mutar su contenido interno (`.add()`), arrojando tamano `2`.

### Cazabugs Nivel 5
- Archivo fuente: `com.taller.nivel5.CazabugsNivel5`
- **Bug 12 (Linea 5 original)**: `private ArrayList<Personaje> miembros;` sin instanciar detona `NullPointerException`.
  - Correccion: Inicializar con `= new ArrayList<>();`.
- **Bug 13 (Linea 8 original)**: `if (miembros.size() > Reglas.MAX_MIEMBROS)` permite registrar 4 elementos por evaluacion no estricta.
  - Correccion: Usar `>= Reglas.MAX_MIEMBROS`.

### Retos del Nivel 5
- **Reto 5.1: La Mochila del Cronista** (`com.taller.nivel5.Reto5_1_MochilaCronista`):
  - Clase `Objeto` inmutable y `Mochila` con tope de 1000 gramos.
  - El objeto descartado (500 g) no ingresa pero conserva su existencia independiente.
- **Reto 5.2: Sella la Arena** (`com.taller.nivel5.Reto5_2_SelloArena`):
  - Verificacion de errores del compilador ante las 3 violaciones de `final`.
- **Reto 5.3: Lider del Escuadron (Extra)** (`com.taller.nivel5.Reto5_3_LiderEscuadron`):
  - Metodo `masFuerte()` gestiona con seguridad listas vacias retornando `null` sin excepciones.

---

## Jefe Final: Batalla contra el Dragon Null

### Fase 1: Lectura del Mapa UML
1. **Relacion entre Escuadron y Personaje**: Agregacion ("tiene un"), representada formalmente por un rombo vacio (`◇───>`).
2. **Metodos que sobrescribe Guerrero**: `atacar()` y `recibirDanio(int)`.
3. **Utilidad de getNombre() final**: Asegura que ninguna subclase suplante la identidad del heroe.

### Fase 2: Forja al Arquero
- Archivo fuente: `com.taller.jefefinal.Arquero`
- Clase implementada con `extends Personaje`, llamada a `super(...)` y `@Override public int atacar() { return ataque + precision; }`.
- Puede invocar `getVida()` y `recibirDanio()` porque los hereda directamente de `Personaje`.

### Fase 3: Invoca al Dragon
- Archivo fuente: `com.taller.jefefinal.Dragon`
- Declarado como `final class Dragon extends Personaje`.
- Metodo `atacar(int ronda)` constituye una **sobrecarga** de `atacar()`.
- Intentar derivar `class DragonBebe extends Dragon` provoca el error: `cannot inherit from final Dragon`.

### Fase 4: La Batalla con Orden Original (Derrota)
- Archivo fuente: `com.taller.jefefinal.BatallaFase4Derrota`
- Orden de ingreso: 1. Lira (Mago), 2. Aria (Arquero), 3. Brako (Guerrero).
- Resultado: **GAME OVER en la ronda 8**.
- Justificacion: Lira (70 HP) recibe los ataques de 35 y perece en la ronda 2, suprimiendo prematuramente 24 puntos de DPS. Luego Aria recibe el golpe critico de 70 en la ronda 3 y muere en la 4. Brako queda en solitario y no puede superar al dragon.

### Fase 5: Estrategia Demostrada (Victoria Garantizada)
- Archivo fuente: `com.taller.jefefinal.BatallaFase5Victoria`
- Orden estrategico del gremio:
  1. **Brako (Guerrero)**: Tanque principal. Su armadura reduce en 10 cada golpe recibido.
  2. **Aria (Arquero)**: Danio a distancia (20 DPS).
  3. **Lira (Mago)**: Maximo DPS (24 DPS), protegida en la retaguardia.

#### Tabla Demostrada de Combate (Verificada en Consola)

| Ronda  | Danio Esc. | Vida Dragon | Objetivo | Golpe | Vida Brako | Vida Aria | Vida Lira |
| :---   | :---       | :---        | :---     | :---  | :---       | :---      | :---      |
| inicio | --         | 330         | --       | --    | 120        | 90        | 70        |
| 1      | 59         | 271         | Brako    | 35    | 95         | 90        | 70        |
| 2      | 59         | 212         | Brako    | 35    | 70         | 90        | 70        |
| 3      | 59         | 153         | Brako    | 70    | 10         | 90        | 70        |
| 4      | 59         | 94          | Brako    | 35    | 0          | 90        | 70        |
| 5      | 44         | 50          | Aria     | 35    | 0          | 55        | 70        |
| 6      | 44         | 6           | Aria     | 70    | 0          | 0         | 70        |
| 7      | 24         | 0           | --       | --    | 0          | 0         | 70        |

**Resultado Final: VICTORIA en la ronda 7.**
El dragon cae en la ronda 7 ante el ataque de Lira antes de poder asestar su golpe.

### Modo Dificil (Bonus Extra)
- Archivo fuente: `com.taller.jefefinal.ModoDificilDragon`
- El golpe varia entre 25 y 45 con `25 + (int)(Math.random() * 21)`.
- La tabla estatica deja de garantizar la victoria porque la estocasticidad puede ocasionar la caida de Brako una ronda antes si el dragon encadena golpes maximos.

### Preguntas Posteriores a la Batalla
1. **Incorporacion de Sanador**: Gracias al polimorfismo, el bucle principal de combate no sufre ninguna modificacion; unicamente se anade la linea `escuadron.agregar(new Sanador(...))`.
2. **Riesgo de atributos publicos**: Si `vida` fuese publica, cualquier rutina externa podria asignar `dragon.vida = 0`, corrompiendo las reglas del combate.
3. **Dragon final vs Personaje no final**: `Dragon` es una entidad terminal que no debe ser adulterada; `Personaje` debe permanecer abierto a la extension como base de la jerarquia.

---

## Consolidado de los 13 Bugs del Taller

1. **Nivel 1 - Bug 1**: Variable local `Heroe luna;` sin instanciar. -> Inicializar con `new Heroe();`.
2. **Nivel 1 - Bug 2**: Metodo `void saludar()` intentando retornar String. -> Cambiar firma a `String saludar()`.
3. **Nivel 2 - Bug 3**: Constructor con tipo `void` (`public void Arma(...)`). -> Remover `void`.
4. **Nivel 2 - Bug 4**: Asignacion de parametro a si mismo `nombre = nombre;`. -> Incorporar `this.nombre = nombre;`.
5. **Nivel 2 - Bug 5**: Getter privado `private int getDanio()`. -> Cambiar a `public int getDanio()`.
6. **Nivel 3 - Bug 6**: Subclase `Grifo` sin llamada al constructor padre. -> Anadir `super(velocidad);`.
7. **Nivel 3 - Bug 7**: Typo en firma de metodo sobrescrito `public void mostar()`. -> Corregir a `mostrar()`.
8. **Nivel 3 - Bug 8**: Acceso directo a atributo privado del padre `velocidad`. -> Cambiar a `protected` en la clase base.
9. **Nivel 4 - Bug 9**: Anotacion `@Override` sobre metodo con parametros distintos (`atacar(int bonus)`). -> Remover `@Override` o unificar firma sin parametros.
10. **Nivel 4 - Bug 10**: Posicion `arena[2]` nula en arreglo predimensionado. -> Instanciar el elemento faltante.
11. **Nivel 4 - Bug 11**: Cast directo sin validacion de Guerrero a Mago. -> Validar con `instanceof` antes de efectuar downcasting.
12. **Nivel 5 - Bug 12**: Coleccion `ArrayList<Personaje> miembros;` sin inicializar. -> Instanciar con `new ArrayList<>()`.
13. **Nivel 5 - Bug 13**: Comparacion con `>` en lugar de `>=` para cupo maximo de escuadron. -> Emplear `>= Reglas.MAX_MIEMBROS`.

---

## Cierre: Ticket de Salida 3-2-1 e Insignias

### Ticket de Salida 3-2-1
- **3 conceptos dominados**:
  1. *Diferencia entre Clase y Objeto*: La clase es el molde estatico; el objeto es la instancia viva e independiente alojada en el Heap.
  2. *Encapsulamiento y Control de Invariantes*: Mantener los atributos en privado y validar mutaciones mediante setters asegura que el objeto nunca entre en un estado invalido.
  3. *Polimorfismo y Enlace Dinamico*: Una referencia de tipo ancestro puede albergar cualquier clase derivada, ejecutando en tiempo de ejecucion la version del metodo que corresponde al objeto real.
- **2 errores superados**:
  1. No colocar tipo de retorno `void` a un constructor.
  2. Recordar siempre incluir `this.` para evitar sombreado de parametros y `super(...)` en la primera linea de constructores derivados.
- **1 pregunta de profundizacion**:
  1. ¿En que escenarios arquitectonicos de gran escala es preferible favorecer la composicion frente a la herencia profunda?

### Insignias Obtenidas
- Forjador: Retos 1.1 a 1.3 superados.
- Guardian de la boveda: Cuenta del gremio protegida y validada.
- Heredero: Jerarquia de herencia modelada y compilada.
- Mil rostros: Arquero integrado en la arena polimorfica sin modificar el ciclo de ataque.
- Sello final: Restricciones de inmutabilidad y herencia con `final` demostradas.
- Cazador de Null: Dragon Null derrotado con estrategia matematica en la ronda 7.
- Cazabugs: Los 13 bugs identificados, explicados y corregidos.
- Mente propia: Taller resuelto con codigo propio, limpio y validado al 100%.
