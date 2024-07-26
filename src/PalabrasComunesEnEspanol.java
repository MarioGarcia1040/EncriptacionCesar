/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase principal - palabrasComunesEnEspanol, realiza busqueda de una lista de palabras comunes en español despues de des-
 plazar los caracteres buscando coincidencias para determinar que es un texto en claro
 Autor - Mario García. mariogarcia1040@gmail.com
 23-Abril-2024
*/
public class PalabrasComunesEnEspanol {
    // Buscamos las palabras más comunes en el idioma español
    public boolean buscarPalabrasComunes(String cadenaProcesada) {
        // Lista de palabras comunes en el español
        String listaDePalabras = "ante bajo con contra de desde hacia hasta para por según segun sin sobre tras " +
                "humanidad humano persona gente hombre mujer bebé niño niña adolescente adulto anciano don doña señor " +
                "señora caballero dama individuo cuerpo pierna pie talón espinilla rodilla muslo cabeza cara boca labio " +
                "diente ojo nariz barba bigote cabello oreja cerebro estómago brazo codo hombro uña mano muñeca palma " +
                "dedo trasero abdomen hígado músculo cuello corazón mente alma espíritu pecho cintura cadera espalda " +
                "sangre carne piel hueso resfriado gripe diarrea salud enfermedad familia amigo amiga conocido conocida" +
                "colega pareja esposo esposa matrimonio amor padre madre hermano hermana hijo hija abuelo abuela bisabuelo" +
                "bisabuela nieto nieta bisnieto bisnieta primo prima tío tía sobrino sobrina criatura especie ser vida" +
                "nacimiento reproducción muerte naturaleza campo bosque selva jungla desierto costa playa río laguna " +
                "lago mar océano cerro monte montaña luz energía animal perro gato vaca cerdo caballo yegua oveja mono" +
                "ratón rata tigre conejo dragón ciervo rana león jirafa elefante pájaro gallina gorrión cuervo águila" +
                "halcón pez camarón langosta sardina atún calamar pulpo insecto bicho mariposa polilla saltamontes araña" +
                "mosca mosquito cucaracha caracol babosa lombriz marisco molusco lagarto serpiente cocodrilo alimento " +
                "comida bebida vegetal planta pasto césped flor fruta semilla árbol hoja raíz tallo hongo ciruela pino " +
                "bambú nuez almendra castaña arroz avena cebada trigo verdura patatas papas judías guisantes porotos " +
                "rábano zanahoria manzana naranja plátano pera castaño durazno tomate sandía carne gaseosa tiempo " +
                "calendario edad época era fecha instante momento segundo minuto hora día semana entre semana fin semana" +
                "mes año década siglo milenio ayer hoy mañana amanecer mediodía tarde anochecer noche lunes martes " +
                "miércoles jueves viernes sábado domingo ambiente espacio entorno área superficie volumen región zona " +
                "lado mundo planeta sol luna estrella galaxia universo clima despejado nublado lluvia nieve viento " +
                "trueno rayo tormenta cielo este oeste sur norte derecha izquierda diagonal exterior interior";

        String[] palabras = listaDePalabras.split("\\s+"); // Manejamos el espacio en blanco de las palabras
        int palabrasEncontradas = 0;
        for (String palabra : palabras) {
            if (cadenaProcesada.toLowerCase().contains(palabra)) {
                palabrasEncontradas++;
            }
            if (palabrasEncontradas > 5) {
                return true;
            }
        }
        return false;
    }

}
