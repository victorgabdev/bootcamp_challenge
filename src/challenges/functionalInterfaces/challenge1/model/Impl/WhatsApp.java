package challenges.functionalInterfaces.challenge1.model.Impl;

import challenges.functionalInterfaces.challenge1.model.MarketingMessages;

public class WhatsApp implements MarketingMessages {


    @Override
    public void sendMessage(String message) {
        System.out.println(message + " - por WhatsApp");
    }
}
