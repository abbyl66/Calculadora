package com.example.calculadora

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException
import java.lang.Long.parseLong

class MainActivity : AppCompatActivity() {

    //Variables de cada botón.
    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var buttonpunt: android.widget.Button
    lateinit var buttonclear: android.widget.Button
    lateinit var buttonigual: android.widget.Button
    lateinit var buttonb: android.widget.Button
    lateinit var buttonmul: android.widget.Button
    lateinit var buttondiv: android.widget.Button
    lateinit var buttonmas: android.widget.Button
    lateinit var buttonmenos: android.widget.Button
    lateinit var buttonDec: android.widget.Button
    lateinit var  bA : android.widget.Button
    lateinit var bB : android.widget.Button
    lateinit var bC : android.widget.Button
    lateinit var bD : android.widget.Button
    lateinit var bE : android.widget.Button
    lateinit var bF : android.widget.Button
    lateinit var buttonBin : android.widget.Button
    lateinit var inputtext: EditText
    lateinit var resulttext: EditText
    var check=0

    //Calcular hexadecimal.
    var datos3: Long = 0
    var operacionHex=""
    var datosHex=""
    var datosHex2=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val orient = resources.configuration.orientation
        supportActionBar?.hide()

        if (orient==Configuration.ORIENTATION_LANDSCAPE){
            calHex()
        }else{
            calNum()
        }

    }

    var camb = false

    fun calNum(){
        //Asignación de los botones con las variables.
        button0=findViewById(R.id.button0)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        buttonclear=findViewById(R.id.buttonclear)
        buttonpunt=findViewById(R.id.buttonpunto)
        buttonigual=findViewById(R.id.buttonigual)
        buttonmas=findViewById(R.id.buttonmas)
        buttonmenos=findViewById(R.id.buttonmenos)
        buttonmul=findViewById(R.id.buttonmul)
        buttondiv=findViewById(R.id.buttondiv)
        buttonb=findViewById(R.id.buttononec)
        resulttext=findViewById(R.id.result)
        inputtext=findViewById(R.id.input)
        buttonDec=findViewById(R.id.buttonDec)
        buttonBin = findViewById(R.id.buttonBin)
        inputtext.movementMethod = ScrollingMovementMethod()
        inputtext.setActivated(true)
        inputtext.setPressed(true)

        var text : String

        //Relación de cada botón con su número o signo, para mostrarlo una vez haya sido introducido.


        buttonBin.setOnClickListener {
                binario()

        }


        buttonDec.setOnClickListener{
            camb=false
            if(camb==false){
                val button2 = findViewById<Button>(R.id.button2)
                val button3 = findViewById<Button>(R.id.button3)
                val button4 = findViewById<Button>(R.id.button4)
                val button5 = findViewById<Button>(R.id.button5)
                val button6 = findViewById<Button>(R.id.button6)
                val button7 = findViewById<Button>(R.id.button7)
                val button8 = findViewById<Button>(R.id.button8)
                val button9 = findViewById<Button>(R.id.button9)

                button2.isEnabled = true
                button3.isEnabled = true
                button4.isEnabled = true
                button5.isEnabled = true
                button6.isEnabled = true
                button7.isEnabled = true
                button8.isEnabled = true
                button9.isEnabled = true

                calNum()

            }


        }

        button0.setOnClickListener{
            text=inputtext.text.toString()+"0"
            inputtext.setText(text)
            result(text)
        }

        button1.setOnClickListener{
            text=inputtext.text.toString()+"1"
            inputtext.setText(text)
            result(text)
        }

        button2.setOnClickListener{
            text=inputtext.text.toString()+"2"
            inputtext.setText(text)
            result(text)
        }

        button3.setOnClickListener{
            text=inputtext.text.toString()+"3"
            inputtext.setText(text)
            result(text)
        }

        button4.setOnClickListener{
            text=inputtext.text.toString()+"4"
            inputtext.setText(text)
            result(text)
        }

        button5.setOnClickListener{
            text=inputtext.text.toString()+"5"
            inputtext.setText(text)
            result(text)
        }

        button6.setOnClickListener{
            text=inputtext.text.toString()+"6"
            inputtext.setText(text)
            result(text)
        }

        button7.setOnClickListener{
            text=inputtext.text.toString()+"7"
            inputtext.setText(text)
            result(text)
        }

        button8.setOnClickListener{
            text=inputtext.text.toString()+"8"
            inputtext.setText(text)
            result(text)
        }

        button9.setOnClickListener{
            text=inputtext.text.toString()+"9"
            inputtext.setText(text)
            result(text)
        }

        buttonpunt.setOnClickListener {
            text = inputtext.text.toString() + "."
            inputtext.setText(text)
            result(text)
        }

        //Controlamos la variable check en los signos.
        buttonmas.setOnClickListener{
            text=inputtext.text.toString()+"+"
            inputtext.setText(text)
            check=check+1
        }

        buttonmenos.setOnClickListener{
            text=inputtext.text.toString()+"-"
            inputtext.setText(text)
            check=check+1
        }

        buttonmul.setOnClickListener{
            text=inputtext.text.toString()+"*"
            inputtext.setText(text)
            check=check+1
        }

        buttondiv.setOnClickListener{
            text=inputtext.text.toString()+"/"
            inputtext.setText(text)
            check=check+1
        }

        buttonigual.setOnClickListener{
            text=resulttext.text.toString()
            inputtext.setText(text)
            resulttext.setText(null)
        }

        buttonclear.setOnClickListener{
            inputtext.setText(null)
            resulttext.setText(null)
        }


        buttonb.setOnClickListener{

            var b: String?=null //String vacío
            if (inputtext.text.length>0){
                val sb: StringBuilder= StringBuilder(inputtext.text) //StringBuilder: concatena la cadena de operaciones.
                val enc=inputtext.text.toString()
                val enc2=enc.last()//last(), método que devuelve el último valor de la cadena de operación.

                if (enc2.equals('+') || enc2.equals('-') || enc2.equals('*') || enc2.equals('/')){
                    check=check-1 //Si el último valor es un signo, asigna(check=0)
                }

                sb.deleteCharAt(inputtext.text.length-1) //Borra un caracter al pulsar el "buttonb".
                b=sb.toString() //Asgina la cadena una vez hecha la acción de borrar un caracter.
                inputtext.setText(b)
                result(b)//Muestra
            }
        }
    }

    //CALCULO BINARIO
    private fun binario() {

        camb= true
        if (camb==true) {
            val button2 = findViewById<Button>(R.id.button2)
            val button3 = findViewById<Button>(R.id.button3)
            val button4 = findViewById<Button>(R.id.button4)
            val button5 = findViewById<Button>(R.id.button5)
            val button6 = findViewById<Button>(R.id.button6)
            val button7 = findViewById<Button>(R.id.button7)
            val button8 = findViewById<Button>(R.id.button8)
            val button9 = findViewById<Button>(R.id.button9)

            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false

            button1 = findViewById(R.id.button1)
            button0 = findViewById(R.id.button0)
            buttonmas = findViewById(R.id.buttonmas)
            buttonmul = findViewById(R.id.buttonmul)
            buttonmenos = findViewById(R.id.buttonmenos)
            buttondiv = findViewById(R.id.buttondiv)
            buttonigual = findViewById(R.id.buttonigual)
            buttonclear = findViewById(R.id.buttonclear)

            button1.setOnClickListener{
                buttonBinario("1")
            }

            button0.setOnClickListener{
                buttonBinario("0")
            }

            buttonmas.setOnClickListener{
                operaciones(Suma);
            }
            buttonmenos.setOnClickListener{
                operaciones(Resta)
            }
            buttonmul.setOnClickListener{
                operaciones(Multiplicacion)
            }
            buttondiv.setOnClickListener{
                operaciones(Division)
            }

            buttonigual.setOnClickListener{
                opcion()
            }

            buttonclear.setOnClickListener{
                clearBin()
            }


        }
    }

    //Variables calcular binario
    var num1:Double = 0.0
    var num2:Double = 0.0
    var operacion: Int = 0
    var bin1:Long = 0
    var bin2:Long = 0



    fun clearBin(){
        num1=0.0
        num2=0.0
        bin1=0
        bin2=0
        operacion=0
        resulttext.setText("")
        inputtext.setText("")
    }

    private  fun opcion() {

        var resultado = when (operacion) {
            Suma -> num1 + num2
            Resta -> num1 - num2
            Multiplicacion -> num1 * num2
            Division -> num1 / num2
            else -> 0
        }

        resulttext.setText(conversorBinario(resultado.toInt()).toString()) //Respuesta
        num1 = resultado as Double
    }

    companion object {
        const val Suma = 1
        const val Resta = 2
        const val Multiplicacion = 3
        const val Division = 4
        const val No_Operacion = 0
    }

    private fun operaciones(operacion: Int) {
        this.operacion = operacion
        inputtext.setText("")
    }

    fun conversorBinario(n: Int): Long {
        var n = n
        var numBinario: Long = 0
        var remainder: Int
        var i = 1
        var step = 1

        while (n != 0) {
            remainder = n % 2
            System.out.printf("Step %d: %d/2, Remainder = %d, Quotient = %d\n", step++, n, remainder, n / 2)
            n /= 2
            numBinario += (remainder * i).toLong()
            i *= 10
        }
        return numBinario
    }

    private fun buttonBinario(num: String) {
        inputtext.setText("${inputtext.text}$num")

        if (operacion == No_Operacion ) {
            bin1 = inputtext.text.toString().toLong();
            num1 = conversorDecimalaBinario(bin1)

        } else {
            bin2 = inputtext.text.toString().toLong();
            num2 = conversorDecimalaBinario(bin2)
        }
    }

    fun conversorDecimalaBinario(binario: Long): Double {
        var binario = binario
        var decimal = 0.0
        var i = 0
        var remainder: Long

        while (binario.toInt() != 0) {
            remainder = binario % 10
            binario /= 10
            decimal += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimal
    }




    //CALCULO HEXADECIMAL.
    fun calHex(){
        button0=findViewById(R.id.button0)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        buttonclear=findViewById(R.id.buttonclear)
        buttonpunt=findViewById(R.id.buttonpunto)
        buttonigual=findViewById(R.id.buttonigual)
        buttonmas=findViewById(R.id.buttonmas)
        buttonmenos=findViewById(R.id.buttonmenos)
        buttonmul=findViewById(R.id.buttonmul)
        buttondiv=findViewById(R.id.buttondiv)
        buttonb=findViewById(R.id.buttononec)
        resulttext=findViewById(R.id.result)
        inputtext=findViewById(R.id.input)
        bA=findViewById(R.id.bA)
        bB=findViewById(R.id.bB)
        bC=findViewById(R.id.bC)
        bD=findViewById(R.id.bD)
        bE=findViewById(R.id.bE)
        bF=findViewById(R.id.bF)
        inputtext.movementMethod = ScrollingMovementMethod()
        inputtext.setActivated(true)
        inputtext.setPressed(true)

        button0.setOnClickListener{
            datosHex+="0"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button1.setOnClickListener{
            datosHex+="1"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button2.setOnClickListener{
            datosHex+="2"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button3.setOnClickListener{
            datosHex+="3"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button4.setOnClickListener{
            datosHex+="4"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button5.setOnClickListener{
            datosHex+="5"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button6.setOnClickListener{
            datosHex+="6"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button7.setOnClickListener{
            datosHex+="7"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button8.setOnClickListener{
            datosHex+="8"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        button9.setOnClickListener{
            datosHex+="9"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        buttonpunt.setOnClickListener{
            datosHex+="0"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        //Controlamos la variable check en los signos.
        buttonmas.setOnClickListener{
            operacionHex="+"
            datosHex2=datosHex
            datosHex=""
            resulttext.setText(datosHex2+ "+")
        }

        buttonmenos.setOnClickListener{
            operacionHex="-"
            datosHex2=datosHex
            datosHex=""
            resulttext.setText(datosHex2+ "-")
        }

        buttonmul.setOnClickListener{
            operacionHex="x"
            datosHex2=datosHex
            datosHex=""
            resulttext.setText(datosHex2+ "x")
        }

        buttondiv.setOnClickListener{
            operacionHex="/"
            datosHex2=datosHex
            datosHex=""
            resulttext.setText(datosHex2+ "/")
        }

        buttonigual.setOnClickListener{
            if(datosHex2=="") datosHex2="0"
            try {
                execHex(hex2dec(datosHex2),hex2dec(datosHex))
            }catch (e: ArithmeticException){
                resulttext.setText("No se puede dividir por 0")
            }
        }

        buttonclear.setOnClickListener{
            datosHex=""
            datosHex2=""
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }


        //Relación de cada botón con su número o signo, para mostrarlo una vez haya sido introducido.(Hex)
        bA.setOnClickListener {
            datosHex+="A"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)

        }

        bB.setOnClickListener{
            datosHex+="B"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        bC.setOnClickListener{
            datosHex+="C"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        bD.setOnClickListener{
            datosHex+="D"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        bE.setOnClickListener{
            datosHex+="E"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }

        bF.setOnClickListener{
            datosHex+="F"
            inputtext.setText(datosHex)
            resulttext.setText(datosHex)
        }


        buttonb.setOnClickListener{

                if(resulttext.text.toString()==""){
                    datosHex=""
                    resulttext.setText(datosHex)
                }else {
                    var datBorrHex = resulttext.text
                    val ultHex = datBorrHex.length
                    var newDatHex = datBorrHex.substring(0, ultHex - 1)
                    datosHex = newDatHex
                    resulttext.setText(datosHex)
                }
        }


    }

    fun execHex(hex1: Long,hex2: Long){
        when(operacionHex){
            "+" -> datos3=(hex1+hex2)
            "-" -> datos3=(hex1-hex2)
            "x" -> datos3=(hex1*hex2)
            "/" -> datos3=(hex1/hex2)
        }
        var hexString=java.lang.Long.toHexString(datos3)
        resulttext.setText(hexString.toUpperCase())
        datosHex= inputtext.text.toString()
    }

    fun hex2dec(hex: String): Long {
        return parseLong(hex,16)
    }

    private fun result (text: String){
        val func: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")//Scripting: Al no estar en la misma clase, lo llama mediante getEngineByName - Rhino(Convierte scripts en clases)
        try {
            val resultado: Any=func.eval(text) //Evalua text, y lo muestra.
            val main=resultado.toString()
            if (check==0){ //Al asignar check=0, borra en "resulttex" la operacion dada y la calcula aunque tenga el signo al final
                resulttext.setText(null)
            }
            else{
                resulttext.setText(main) //Muestra resultado
            }
        }catch (e: ScriptException){
            Log.d("Adv", "Error" ) //Controla el error del Script.
        }



    }
}