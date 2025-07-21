package challenges.functionalInterfaces.challenge1;

import challenges.functionalInterfaces.challenge1.model.Impl.Email;
import challenges.functionalInterfaces.challenge1.model.Impl.SocialMedia;
import challenges.functionalInterfaces.challenge1.model.Impl.WhatsApp;
import challenges.functionalInterfaces.challenge1.model.MarketingMessages;

public class App {
    /*
    1 - Escreva um código para enviar mensagens de marketing, para isso você deve ter a possibilidade de enviar a mesma
    mensagem para serviços diferentes, esses serviços devem ter um metodo para receber a mensagem como parâmetro, os
    serviços que devem estar disponíveis são:

    SMS;
    E-mail;
    Redes Sociais;
    WhatsApp;
     */

    public static void main(String[] args) {
        MarketingMessages messageEmail = new Email();
        messageEmail.sendMessage("Mensagem de teste");

        MarketingMessages messageWhats = new WhatsApp();
        messageWhats.sendMessage("Mensagem de teste");

        MarketingMessages messageSM = new SocialMedia();
        messageSM.sendMessage("Mensagem de teste");
    }
}
