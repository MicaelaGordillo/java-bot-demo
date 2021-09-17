package bo.edu.ucb.est;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelloWorldBot  extends TelegramLongPollingBot {

    private Integer numMess = 1;
    private Integer num1;
    private List<String> mensajes;

    @Override
    public String getBotToken() {
        return "1999218290:AAFKWc9iHSnt5bY61-Y2RRV3Uycw_gHxQAE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        mensajes = new ArrayList();
        llenarListaMensajes();
        System.out.println("Llego mensaje: " + update.toString());
        if(update.hasMessage()) { // Verificamos que tenga mensaje
            SendMessage message = new SendMessage(); // Creo el objeto para enviar un mensaje
            message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
            try {
                if (numMess == 1) {
                    message.setText(mensajes.get(0));
                }
                if (numMess == 2){
                    if (update.getMessage().getText().equals("1")){
                        message.setText(mensajes.get(1));
                    } else{
                        message.setText(mensajes.get(4));
                        execute(message);
                        message.setText(mensajes.get(0));
                        numMess = 1;
                    }
                }
                if (numMess == 3){
                    if (comprobarNumero(update.getMessage().getText())){
                        num1 = Integer.parseInt(update.getMessage().getText()); // Asigna el valor del numero enviado a la variable
                        message.setText(mensajes.get(2));
                    } else{
                        message.setText(mensajes.get(0));
                        numMess = 1;
                    }
                }
                if (numMess == 4){
                    if (comprobarNumero(update.getMessage().getText())){
                        Integer num2 = Integer.parseInt(update.getMessage().getText()); // Asigna el valor del numero enviado a la variable
                        Integer total = num1 + num2;
                        message.setText(mensajes.get(3)+" "+total);
                        execute(message);
                        message.setText(mensajes.get(0));
                        numMess = 1;
                    } else{
                        message.setText(mensajes.get(0));
                        numMess = 1;
                    }
                }
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            numMess++;
        }
    }

    @Override
    public String getBotUsername() {
        return "sumador_bot";
    }

    public void llenarListaMensajes (){
        mensajes.add("Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:" +
                "\n1. Sumar dos números.\n2. Calcular serie de fibonacci.");
        mensajes.add("Ingrese el primer número:");
        mensajes.add("Ingrese el segundo número:");
        mensajes.add("La suma es:");
        mensajes.add("Funcionalidad no implementada, intente otro día.");
    }

    public boolean comprobarNumero (String n){
        boolean flag = true;
        try{
            int aux = Integer.parseInt(n);
        }catch(NumberFormatException ex){
            System.out.println("Error");
            flag = false;
        }
        return flag;
    }
}
